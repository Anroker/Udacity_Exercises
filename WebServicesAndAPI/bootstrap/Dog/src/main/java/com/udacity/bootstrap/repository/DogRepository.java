package com.udacity.bootstrap.repository;

import com.udacity.bootstrap.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DogRepository extends CrudRepository<Dog,Long> {

    Optional<Dog> findByBreed(String name);

    @Query("select id, breed from Dog where id=:id")
    String findBreedById(Long id);

    @Query("select id, breed from Dog")
    List<String> findAllBreed();

    @Query("select id, name from Dog")
    List<String> findAllNames();
}
