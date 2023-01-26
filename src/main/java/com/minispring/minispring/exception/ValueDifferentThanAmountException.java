package com.minispring.minispring.exception;

public class ValueDifferentThanAmountException extends  RuntimeException{
    public ValueDifferentThanAmountException(String msg){
        super(msg,null,true,false);
    }
}
