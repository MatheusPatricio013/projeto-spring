package com.minispring.minispring.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Set;
@Table(name="salesOrder")
public class SalesOrder extends Order{
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

    public SalesOrder(BigDecimal amount, Currency currency, SalesOrderState state, SalesOrderStatus status,
                      InternalPaymentInstruction instruction, Set<InvoiceSalesOrderAssociation> invoiceSalesOrderAssociations) {
        this.amount = amount;
        this.currency = currency;
        this.state = state;
        this.status = status;
        this.instruction = instruction;
        this.invoiceSalesOrderAssociations = invoiceSalesOrderAssociations;
    }

    public SalesOrderState getState() {
        return state;
    }

    public void setState(SalesOrderState state) {
        this.state = state;
    }

    public SalesOrderStatus getStatus() {
        return status;
    }

    public void setStatus(SalesOrderStatus status) {
        this.status = status;
    }

    public InternalPaymentInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(InternalPaymentInstruction instruction) {
        this.instruction = instruction;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Set<InvoiceSalesOrderAssociation> getInvoiceSalesOrderAssociations() {
        return invoiceSalesOrderAssociations;
    }

    public void setInvoiceSalesOrderAssociations(Set<InvoiceSalesOrderAssociation> invoiceSalesOrderAssociations) {
        this.invoiceSalesOrderAssociations = invoiceSalesOrderAssociations;
    }

    @Override
    public String toString() {
        return "\nSalesOrder{" +
                "amount=" + amount +
                ", currency=" + currency +
                ", invoiceSalesOrderAssociations=" + invoiceSalesOrderAssociations +
                "\nExternalReference=" + getExternalReference();
    }
}
