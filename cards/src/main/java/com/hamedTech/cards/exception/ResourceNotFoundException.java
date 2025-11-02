package com.hamedTech.cards.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{


    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue){
        super(String.format("%s resource is not found with feild name %s and feildvalue %s", resourceName, fieldName, fieldValue));
    }
}
