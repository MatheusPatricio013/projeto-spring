package com.minispring.minispring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class NegotiableInstrument extends ExternalPaymentInstruction{
    public static final String OBJECT_TYPE = "NEGOTIABLE_INSTRUMENT";
    private BigDecimal discountAmount;
    private String documentReference;

    @ManyToOne
    private Invoice invoice;


    @OneToOne
    @JsonIgnore
    private Boleto boleto;

    public NegotiableInstrument() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NegotiableInstrument that)) return false;
        if (!super.equals(o)) return false;
        return discountAmount.equals(that.discountAmount) && documentReference.equals(that.documentReference) && invoice.equals(that.invoice) && Objects.equals(boleto, that.boleto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discountAmount, documentReference, invoice, boleto);
    }

    @Override
    public String toString() {
        return "NegotiableInstrument{\n" +
                "ObjectType=" + NegotiableInstrument.OBJECT_TYPE+
                "\ndiscountAmount=" + discountAmount +
                "\ndocumentReference='" + documentReference + '\'' +
                "\ninvoice=" + invoice +
                "\nboleto=" + boleto +
                '}'+"\n";
    }
}
