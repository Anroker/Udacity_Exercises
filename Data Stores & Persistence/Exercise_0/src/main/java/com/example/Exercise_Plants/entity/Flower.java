package com.example.Exercise_Plants.entity;

import javax.persistence.*;

@Entity
public class Flower extends Plant{

    private String color;

    public String getColor() {
        return color;
    }

    public Flower setColor(String color) {
        this.color = color;
        return this;
    }
}
