package com.udacity.bootstrap.service;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Dog not found")
public class BreedNotFoundException extends RuntimeException implements GraphQLError {


    public BreedNotFoundException(String message, String name) {
        super(message);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
