package com.minispring.minispring.model;

import java.net.URI;
import java.util.Set;

public class InternalPaymentInstruction extends PaymentInstruction{
    public static final String OBJECT_TYPE = "INTERNAL_PAYMENT_INSTRUCTION";
    private URI internalReference;
    private Set<PaymentTransaction> paymentTransactions;
    private SalesOrder salesOrder;
    private InternalPaymentStatus status;
    private InternalPaymentState internalPaymentState;



}
