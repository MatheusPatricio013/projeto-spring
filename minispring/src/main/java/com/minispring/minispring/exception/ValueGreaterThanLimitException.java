package com.minispring.minispring.exception;

public class ValueGreaterThanLimitException extends  RuntimeException{
    public ValueGreaterThanLimitException(String msg){
        super(msg);
    }
}
