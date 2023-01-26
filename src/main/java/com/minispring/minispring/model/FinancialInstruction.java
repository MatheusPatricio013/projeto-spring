package com.minispring.minispring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Currency;
@Entity
@Getter
@Setter
public class FinancialInstruction extends Instruction {
    public static final String OBJECT_TYPE = "FINANCIAL_INSTRUCTION";
    @Column(name="amount")
    private BigDecimal amount;
    @Column(name="currency")
    private Currency currency;



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