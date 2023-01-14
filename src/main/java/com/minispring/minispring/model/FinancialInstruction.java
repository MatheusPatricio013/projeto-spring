package com.minispring.minispring.model;

import java.math.BigDecimal;
import java.util.Currency;

public class FinancialInstruction extends Instruction {
    public static final String OBJECT_TYPE = "FINANCIAL_INSTRUCTION";
    private BigDecimal amount;
    private Currency currency;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass())
            return false;
        FinancialInstruction other = (FinancialInstruction) o;
        return this.getId() != null && this.getId().equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}