package com.udacity.restAndGraphQL.web;

import com.udacity.restAndGraphQL.entity.Dog;
import com.udacity.restAndGraphQL.service.DogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DogController {

    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/getAllDogs")
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> list = dogService.retrieveDogs();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getDogBreed")
    public ResponseEntity<List<String>> getDogBreed() {
        List<String> list = dogService.retrieveDogBreed();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getDogBreedById/{id}")
    public String retrieveDogBreedById(@PathVariable Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogService.retrieveDogBreedById(id));
        return optionalBreed.get();
//        return optionalBreed.orElseThrow(DogNotFoundException::new);
    }

    @GetMapping("/getAllDogsNames")
    public ResponseEntity<List<String>> getAllDogsNames() {
        List<String> list = dogService.retrieveDogNames();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
