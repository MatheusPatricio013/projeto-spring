package com.minispring.minispring.usecase;

import com.minispring.minispring.exception.ValueDifferentThanAmountException;
import com.minispring.minispring.model.InvoiceSalesOrderAssociation;
import com.minispring.minispring.model.SalesOrder;

import java.util.Set;

public class AddInvoiceSalesOrderAssociation {
    public void execute(Set<InvoiceSalesOrderAssociation> associations, Set<SalesOrder> salesOrders, InvoiceSalesOrderAssociation association, SalesOrder salesOrder, Double value){
        Double totalAmount = 0.0;
        Double valueInvoiced = 0.0;
        for (InvoiceSalesOrderAssociation as : associations) {
            valueInvoiced += association.getInvoice().getAmount().doubleValue();
            System.out.println(as);

        }
        for (SalesOrder sl : salesOrders){
            totalAmount += sl.getAmount().doubleValue();
        }
        if(value > totalAmount){
            throw new ValueDifferentThanAmountException("Value is greater than amount!");
        }else {
            associations.add(association);
            salesOrder.setInvoiceSalesOrderAssociations(associations);
        }
        }
}
