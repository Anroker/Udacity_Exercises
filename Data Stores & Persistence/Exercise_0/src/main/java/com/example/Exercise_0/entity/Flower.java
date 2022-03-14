package com.example.Exercise_0.entity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "plant")
public class Flower {
    @Id
    @GeneratedValue
    private Long id;

    @Nationalized // should use @Nationalized instead of @Type=nstring
    private String name;
    private String color;
    @Column(precision=12, scale=4)
    private BigDecimal price; // BigDecimal is the standard Java class for currency math

    public Long getId() {
        return id;
    }

    public Flower setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Flower setName(String name) {
        this.name = name;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Flower setColor(String color) {
        this.color = color;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Flower setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    /* getters and setters*/
}
