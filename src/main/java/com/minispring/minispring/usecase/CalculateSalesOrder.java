package com.minispring.minispring.usecase;

import com.minispring.minispring.exception.ValueGreaterThanAmountException;
import com.minispring.minispring.model.InvoiceSalesOrderAssociation;
import com.minispring.minispring.model.SalesOrder;


import java.util.Set;

public class CalculateSalesOrder {
    public Double execute(SalesOrder salesOrder, Set<SalesOrder> salesOrders, String externalReference) {
        Set<InvoiceSalesOrderAssociation> invoiceSalesOrderAssociations = salesOrder.getInvoiceSalesOrderAssociations();
        Double valueInvoiced = 0.0;
        Double totalAmount = 0.0;
        Double currentValueInvoiced = 0.0;
        for (InvoiceSalesOrderAssociation association : invoiceSalesOrderAssociations) {
            valueInvoiced += association.getInvoice().getAmount().doubleValue();
            if(association.getInvoice().getExternalReference().equals(externalReference)){
                currentValueInvoiced+= association.getInvoice().getAmount().doubleValue();
            }
        }
        for(SalesOrder sl: salesOrders){
            totalAmount+= sl.getAmount().doubleValue();

        }
        if(valueInvoiced > totalAmount){
            throw  new ValueGreaterThanAmountException("Value invoiced greater than amount!");
        }
        else {

            System.out.println("\nValor restante para faturar: R$ " +( salesOrder.getAmount().doubleValue() - currentValueInvoiced));
            System.out.println("\nValor faturado: R$ " +valueInvoiced);
            if (salesOrder.getAmount().doubleValue() - valueInvoiced == 0.0) {
                System.out.println("\nPedido totalmente faturado!");
                return salesOrder.getAmount().doubleValue() - valueInvoiced;
            }
            return salesOrder.getAmount().doubleValue() - valueInvoiced;
        }
    }
}
