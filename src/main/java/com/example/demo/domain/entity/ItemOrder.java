package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Table
@Entity
@NoArgsConstructor
public class ItemOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "item_id" ,nullable = false)
    private Item item;
    @ManyToOne
    @JoinColumn(name = "order_id" ,nullable = false)
    private Order order;
}
