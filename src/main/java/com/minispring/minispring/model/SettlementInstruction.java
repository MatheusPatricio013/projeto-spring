package com.minispring.minispring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.Currency;

@Entity
@Table(name="settlementInstruction")
@Getter
@Setter
public class SettlementInstruction implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "settlementInstructionGenerator",strategy = GenerationType.SEQUENCE)
    @Column(name="id",insertable = true,updatable = false,nullable = false)
    private Long id;
    @Column(name="amount",nullable = false)
    private BigDecimal amount;
    @Column(name="currency",nullable = false)
    private Currency currency;
    @Column(name="dueDate",nullable = true)
    private LocalDateTime dueDate;
    @ManyToOne
    @JoinColumn(name = "external_payment_instruction_ID")
    private ExternalPaymentInstruction externalPaymentInstruction;
    @Column(name="state",nullable = false)
    private SettlementInstructionState state;
    @Column(name="status",nullable = false)
    private SettlementInstructionStatus status;


}
