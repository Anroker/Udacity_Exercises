package com.udacity.restAndGraphQL.service;



import com.udacity.restAndGraphQL.entity.Dog;

import java.util.List;

public interface DogService {

    List<Dog> retrieveDogs();

    List<String> retrieveDogBreed();

    String retrieveDogBreedById(Long id);

    List<String> retrieveDogNames();

}
