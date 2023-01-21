package com.minispring.minispring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Set;
@Table(name="salesOrder")
@Getter
@Setter
@AllArgsConstructor
public class SalesOrder extends Order implements Serializable {
    private static final Long serialVersionUID = 1L;
    public static final String OBJECT_TYPE = "SALES_ORDER";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @Column (name="amount")
    private BigDecimal amount;
    @Column(name="currency")
    private Currency currency;
    @Column(name="state")
    private SalesOrderState state;
    @Column(name="status")
    private SalesOrderStatus status;

    private InternalPaymentInstruction instruction;

    private Set<InvoiceSalesOrderAssociation> invoiceSalesOrderAssociations;

    public SalesOrder(){}


    @Override
    public String toString() {
        return "\nSalesOrder{" +
                "amount=" + amount +
                ", currency=" + currency +
                ", invoiceSalesOrderAssociations=" + invoiceSalesOrderAssociations +
                "\nExternalReference=" + getExternalReference();
    }
}
