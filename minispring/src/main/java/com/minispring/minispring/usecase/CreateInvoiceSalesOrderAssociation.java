package com.minispring.minispring.usecase;

import com.minispring.minispring.model.Invoice;
import com.minispring.minispring.model.InvoiceSalesOrderAssociation;
import com.minispring.minispring.model.SalesOrder;

import java.time.LocalDateTime;
import java.util.Currency;

public class CreateInvoiceSalesOrderAssociation {
    public InvoiceSalesOrderAssociation execute(Invoice invoice, SalesOrder salesOrder){
        InvoiceSalesOrderAssociation invoiceSalesOrderAssociation= new InvoiceSalesOrderAssociation();
        invoiceSalesOrderAssociation.setInvoice(invoice);
        invoiceSalesOrderAssociation.setSalesOrder(salesOrder);
        invoiceSalesOrderAssociation.setAmount(salesOrder.getAmount());
        invoiceSalesOrderAssociation.setDate(LocalDateTime.now());
        invoiceSalesOrderAssociation.setCurrency(Currency.getInstance("BRL"));
        return  invoiceSalesOrderAssociation;
    }
}
