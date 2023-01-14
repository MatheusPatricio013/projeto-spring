package com.minispring.minispring.model;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.Objects;

public class InvoiceSalesOrderAssociation {
    private Long id;
    private LocalDateTime date;
    private BigDecimal amount;
    private Currency currency;
    private Invoice invoice;
    private SalesOrder salesOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public SalesOrder getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }



    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "\nInvoiceSalesOrderAssociation{" +
                ", date=" + date +
                ", amount=" + amount +
                ", currency=" + currency +
                ", invoiceExternalReference=" + invoice.getExternalReference()+
                ", invoiceAmount=" + invoice.getAmount();
    }
}
