package com.minispring.minispring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExternalReferenceNotFoundException extends RuntimeException{
    public ExternalReferenceNotFoundException(String externalReference) {
        super(String.format("External reference %s not found!",externalReference),null,true,false);
    }
}
