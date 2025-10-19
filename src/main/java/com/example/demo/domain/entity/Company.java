package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Table
@Entity
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String direction;
    @OneToMany
    private List<Usuario> usuarioList;
    @OneToMany
    private List<Item> itemList;
    @OneToMany
    private List<Mesa> mesaList;
}
