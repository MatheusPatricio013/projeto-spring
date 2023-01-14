package com.minispring.minispring.model;

public class PaymentTransaction extends FinancialTransaction{
    public static final String OBJECT_TYPE = "PAYMENT_TRANSACTION";
    private PaymentTransactionStatus status;
    private InternalPaymentInstruction internalPaymentInstruction;
    private ExternalPaymentInstruction externalPaymentInstruction;

    public PaymentTransactionStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentTransactionStatus status) {
        this.status = status;
    }

    public InternalPaymentInstruction getInternalPaymentInstruction() {
        return internalPaymentInstruction;
    }

    public void setInternalPaymentInstruction(InternalPaymentInstruction internalPaymentInstruction) {
        this.internalPaymentInstruction = internalPaymentInstruction;
    }

    public ExternalPaymentInstruction getExternalPaymentInstruction() {
        return externalPaymentInstruction;
    }

    public void setExternalPaymentInstruction(ExternalPaymentInstruction externalPaymentInstruction) {
        this.externalPaymentInstruction = externalPaymentInstruction;
    }

}
