package com.minispring.minispring.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Invoice extends  ExternalPaymentInstruction{
    public static final String OBJECT_TYPE = "INVOICE";
    @Column(nullable = true)
    @OneToMany
    private List<NegotiableInstrument> negotiableInstruments;


    @Override
    public String toString() {
        return "Invoice{" +
                "negotiableInstruments=" + negotiableInstruments +
                '}';
    }
}
