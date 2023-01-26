package com.minispring.minispring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvoiceNotFoundException extends RuntimeException{
    public InvoiceNotFoundException(Long id) {
        super(String.valueOf(HttpStatus.NOT_FOUND.value() + " Invoice not found with id ="+ id),null,true,false);
    }
}
