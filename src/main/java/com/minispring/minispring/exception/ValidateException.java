package com.minispring.minispring.exception;


import java.util.LinkedHashSet;
import java.util.Set;

public class ValidateException extends RuntimeException {
    public ValidateException(Set<Exception> violationExceptions,Class domain) {
        super(String.format("Violation Exceptions : %s \n class: %s",parseException(violationExceptions) ,domain.getSimpleName()),null,true,false);
    }

    private static Set<String> parseException(Set<Exception> exceptions){
        Set<String> exceptionsMessage = new LinkedHashSet<>();
        for(Exception ex: exceptions){
            exceptionsMessage.add(ex.getMessage());
        }
        return  exceptionsMessage;
    }
}
