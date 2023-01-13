package com.minispring.minispring.usecase;

import com.minispring.minispring.exception.ValueGreaterThanAmountException;
import com.minispring.minispring.model.SalesOrder;

public class ValidateValueInvoice {
    public String execute(Double value, SalesOrder salesOrder){
        if(salesOrder.getAmount().doubleValue() < value){
            throw new ValueGreaterThanAmountException("Valor muito alto!");
        }
        else{
            return  "Amount sent!";
        }

    }
}
