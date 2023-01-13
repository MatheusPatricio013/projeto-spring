package com.minispring.minispring.usecase;


import com.minispring.minispring.model.InstructionInvolvement;
import com.minispring.minispring.model.SalesOrder;
import org.springframework.stereotype.Service;

import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

@Service
public class CreateSalesOrders {
    DiscountCreditInstructionInvolvement discountCreditInstructionInvolvement = new DiscountCreditInstructionInvolvement();
    Double amount =0.0;
    Double totalAmount = 0.0;
    AddSalesOrder addSalesOrder = new AddSalesOrder();

    Currency currency = Currency.getInstance("BRL");
    Set<SalesOrder> salesOrders = new HashSet<>();

    public Set<SalesOrder> execute(InstructionInvolvement currentInvolved) {
        if (currentInvolved != null) {

            return salesOrders;
        }
        else{
        return  salesOrders;
        }
    }



}
