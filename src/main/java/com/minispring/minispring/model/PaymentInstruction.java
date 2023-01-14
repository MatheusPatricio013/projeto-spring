package com.minispring.minispring.model;

public class PaymentInstruction extends FinancialInstruction {

    public static final String OBJECT_TYPE = "PAYMENT_INSTRUCTION";



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PaymentInstruction other = (PaymentInstruction) obj;
        return this.getId() != null && this.getId().equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}