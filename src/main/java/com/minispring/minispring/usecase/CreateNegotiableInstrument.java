package com.minispring.minispring.usecase;

import com.minispring.minispring.model.Boleto;
import com.minispring.minispring.model.NegotiableInstrument;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

public class CreateNegotiableInstrument {

    public NegotiableInstrument execute(Boleto boleto, String documentReference, BigDecimal discountAmount, LocalDateTime dueDate){
        NegotiableInstrument negotiableInstrument = new NegotiableInstrument();
        negotiableInstrument.setDate(LocalDateTime.now());
        negotiableInstrument.setAmount(discountAmount);
        negotiableInstrument.setDocumentReference(documentReference);
        negotiableInstrument.setCurrency(Currency.getInstance("BRL"));
        negotiableInstrument.setBoleto(boleto);
        negotiableInstrument.setDiscountAmount(BigDecimal.valueOf(0.0));
        negotiableInstrument.setDueDate(dueDate);
        return negotiableInstrument;
    }

}
