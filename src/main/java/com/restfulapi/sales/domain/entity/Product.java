package com.restfulapi.sales.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "description")
    @NotEmpty(message = "Description cannot be empty")
    private String description;

    @Column(name = "unit_price")
    @NotNull(message = "Price cannot be null")
    private BigDecimal price;
}
