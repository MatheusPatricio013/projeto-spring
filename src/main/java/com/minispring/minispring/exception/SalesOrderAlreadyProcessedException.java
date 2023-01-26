package com.minispring.minispring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class SalesOrderAlreadyProcessedException extends RuntimeException {
    public SalesOrderAlreadyProcessedException(Long id) {
        super(String.valueOf(HttpStatus.NOT_ACCEPTABLE.value() + " Sales Order already processed with id ="+ id),null,true,false);
    }
}
