package com.minispring.minispring.exception;

public class ValueGreaterThanAmountException extends  RuntimeException{
    public ValueGreaterThanAmountException(String msg){
        super(msg);
    }
}
