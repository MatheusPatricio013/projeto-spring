package com.minispring.minispring.model;

import java.math.BigDecimal;
import java.util.Currency;

public class FinancialTransaction extends Transaction{
    public static final String OBJECT_TYPE = "FINANCIAL_TRANSACTION";
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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FinancialTransaction other = (FinancialTransaction) obj;
        return this.getId() != null && this.getId().equals(other.getId());
    }

}
