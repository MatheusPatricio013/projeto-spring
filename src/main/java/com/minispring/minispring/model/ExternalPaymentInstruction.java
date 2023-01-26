package com.minispring.minispring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public class ExternalPaymentInstruction extends PaymentInstruction{
      public static final String OBJECT_TYPE = "EXTERNAL_PAYMENT_INSTRUCTION";
    @Id
    @GeneratedValue(generator = "settlementInstructionGenerator",strategy = GenerationType.SEQUENCE)
    @Column(name="id",insertable = true,updatable = false,nullable = false)
    private Long id;
    private ExternalPaymentInstructionStatus status;
    private ExternalPaymentInstructionState state;
}
