package com.minispring.minispring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SalesOrderNotFoundException extends RuntimeException {

    public SalesOrderNotFoundException(Long id) {
       super(String.valueOf(HttpStatus.NOT_FOUND.value() + " Sales Order not found with id ="+ id),null,true,false);
    }

}
