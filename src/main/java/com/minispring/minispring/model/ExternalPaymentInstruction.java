package com.minispring.minispring.model;

import java.util.Set;

public class ExternalPaymentInstruction extends PaymentInstruction{
    public static final String OBJECT_TYPE = "EXTERNAL_PAYMENT_INSTRUCTION";
    private Set<SettlementInstruction> settlementInstructions;
    private Set<PaymentTransaction> paymentTransactions;
}
