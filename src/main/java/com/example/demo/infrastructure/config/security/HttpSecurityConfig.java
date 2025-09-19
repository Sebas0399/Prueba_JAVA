package com.example.demo.infrastructure.config.security;

import com.example.demo.infrastructure.config.security.filter.JwtAuthenticatonFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import java.security.Permission;

@Component
@EnableWebSecurity
public class HttpSecurityConfig {
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private JwtAuthenticatonFilter authenticatonFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionManConfig->sessionManConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterAfter(authenticatonFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(authConfig->{
                    authConfig.requestMatchers(HttpMethod.POST,"/auth/authenticate").permitAll();
                    authConfig.requestMatchers(HttpMethod.POST,"/usuarios/register").permitAll();
                    authConfig.requestMatchers(HttpMethod.GET,"/actuator/health").permitAll();
                    authConfig.requestMatchers("/error").permitAll();
                    authConfig.requestMatchers("/tareas/**").authenticated();
                    authConfig.requestMatchers("/tareas/usuario/**").authenticated();      // usuarios logueados
                    authConfig.anyRequest().denyAll();

                });
        return httpSecurity.build();
    }
}
