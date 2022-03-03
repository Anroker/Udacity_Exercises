package com.example.dog_springdatarest.repository;

import com.example.dog_springdatarest.entity.Dog;
import org.springframework.data.repository.CrudRepository;


public interface DogRepository extends CrudRepository<Dog, Long> {
}
