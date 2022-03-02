package com.udacity.restAndGraphQL.mutuator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.restAndGraphQL.entity.Dog;
import com.udacity.restAndGraphQL.repository.DogRepository;
import com.udacity.restAndGraphQL.service.BreedNotFoundException;
import com.udacity.restAndGraphQL.service.DogNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private final DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public boolean deleteDogBreed(String name){
        boolean deleted = false;

        Optional<Dog> dogOptional = dogRepository.findByBreed(name);
        if (dogOptional.isPresent()){
            dogRepository.delete(dogOptional.get());
            deleted = true;
        }

        if (!deleted) {
            throw new BreedNotFoundException("Breed not found", name);
        }

        return deleted;
    }

    public Dog updateDogName(String newName, Long id) {
        Optional<Dog> dogOptional = dogRepository.findById(id);

        if (dogOptional.isPresent()){
            Dog dog = dogOptional.get();
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundException("Dog not found", id);
        }
    }

}
