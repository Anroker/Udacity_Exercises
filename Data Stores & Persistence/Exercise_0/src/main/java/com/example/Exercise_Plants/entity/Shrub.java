package com.example.Exercise_Plants.entity;

import javax.persistence.Entity;

@Entity
public class Shrub extends Plant {

    private int height;
    private int width;

    public int getHeight() {
        return height;
    }

    public Shrub setHeight(int height) {
        this.height = height;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public Shrub setWidth(int width) {
        this.width = width;
        return this;
    }
}
