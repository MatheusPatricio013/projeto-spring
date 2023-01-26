package com.minispring.minispring.usecase;


import com.minispring.minispring.exception.ValueDifferentThanAmountException;
import com.minispring.minispring.model.SalesOrder;

public class ValidateValueInvoice {
    public String execute(Double value, SalesOrder salesOrder){
        if(salesOrder.getAmount().doubleValue() < value){
            throw new ValueDifferentThanAmountException("Valor muito alto!");
        }
        else{
            return  "Amount sent!";
        }

    }
}
