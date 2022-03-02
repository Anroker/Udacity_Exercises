package com.example.dog_springdatarest.entity;

import javax.persistence.*;

@Entity
@Table(name = "dog")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String breed;
    private String origin;

    public Dog() {
    }

    public Dog(Long id, String name, String breed, String origin) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.origin = origin;
    }

    public Dog(String name, String breed, String origin) {
        this.name = name;
        this.breed = breed;
        this.origin = origin;
    }

    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public String getOrigin() {
        return origin;
    }

    public Dog setOrigin(String origin) {
        this.origin = origin;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Dog setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Dog setName(String name) {
        this.name = name;
        return this;
    }

    public String getBreed() {
        return breed;
    }

    public Dog setBreed(String address) {
        this.breed = address;
        return this;
    }
}
