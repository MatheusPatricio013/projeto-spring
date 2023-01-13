package com.minispring.minispring.model;

import java.math.BigDecimal;
import java.util.Currency;

public class InvoicePaymentMethod {
    private Long id;
    private BigDecimal amount;
    private Currency currency;
    private InvoicePaymentMethodType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public InvoicePaymentMethodType getType() {
        return type;
    }

    public void setType(InvoicePaymentMethodType type) {
        this.type = type;
    }
}
