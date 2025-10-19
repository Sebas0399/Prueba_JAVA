package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Table
@Entity
@NoArgsConstructor
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer capacidad;
    private  Boolean disponible;
    @ManyToOne
    @JoinColumn(name = "company_id" ,nullable = false)
    private Company company;
    @OneToMany
    private List<Order> orderList;
}
