package com.udacity.restAndGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.restAndGraphQL.entity.Dog;
import com.udacity.restAndGraphQL.repository.DogRepository;
import com.udacity.restAndGraphQL.service.DogNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    private final DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id) {
        Optional<Dog> dogOptional = dogRepository.findById(id);
        if (dogOptional.isPresent()){
            return dogOptional.get();
        } else {
            throw new DogNotFoundException("Dog not found", id);
        }
    }
}
