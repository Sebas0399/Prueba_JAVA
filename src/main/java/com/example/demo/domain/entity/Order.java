package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Table
@Entity
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime date;
    private BigDecimal totalAmount;
    @ManyToOne
    @JoinColumn(name = "company_id" ,nullable = false)
    private Company company;
    @ManyToOne
    @JoinColumn(name = "mesa_id" ,nullable = false)
    private Mesa mesa;
    @OneToMany
    private List<ItemOrder> itemOrders;
}
