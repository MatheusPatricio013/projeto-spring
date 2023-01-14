package com.minispring.minispring.usecase;

import com.minispring.minispring.model.InstructionInvolvement;
import com.minispring.minispring.model.SalesOrder;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;

@Service
public class CalculateInvoice {

    public void execute(Double valueInvoiced, InstructionInvolvement obligor, SalesOrder salesOrder){

    if(valueInvoiced == null || obligor ==null || salesOrder == null){
        System.out.println("Values null!");
    }
    else{

        if(salesOrder.getAmount().doubleValue() - valueInvoiced < salesOrder.getAmount().doubleValue()){
         Double returnCredit = obligor.getCreditLimit().doubleValue();
         obligor.setCreditLimit(BigDecimal.valueOf(returnCredit));
            System.out.println("Valor estornado: R$ "+valueInvoiced);
        }

    }
    }
}
