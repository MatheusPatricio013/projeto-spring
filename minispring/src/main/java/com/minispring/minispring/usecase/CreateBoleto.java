package com.minispring.minispring.usecase;

import com.minispring.minispring.model.Boleto;
import com.minispring.minispring.model.BoletoState;
import com.minispring.minispring.model.NegotiableInstrument;


public class CreateBoleto extends Boleto{
   public Boleto execute(NegotiableInstrument negotiableInstrument){

       Boleto boleto = new Boleto();
       boleto.setAmount(negotiableInstrument.getAmount());
       boleto.setCurrency(negotiableInstrument.getCurrency());
       boleto.setDueDate(negotiableInstrument.getDueDate().plusDays(6));
       boleto.setDate(negotiableInstrument.getDate());
       boleto.setExternalReference(negotiableInstrument.getExternalReference());
       boleto.setState(BoletoState.OPEN);
       boleto.setDocumentReference(negotiableInstrument.getDocumentReference());
       boleto.setBankReference("3984");
       return boleto;}
}

