package com.minispring.minispring.exception;

public class NullValueException extends RuntimeException{

    public NullValueException(String nullValue) {
        super(String.format("This value must be null : %s",nullValue));
    }
}
