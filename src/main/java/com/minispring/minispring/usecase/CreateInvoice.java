package com.minispring.minispring.usecase;

import com.minispring.minispring.exception.*;
import com.minispring.minispring.model.*;
import com.minispring.minispring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class CreateInvoice {
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private NegotiableInstrumentRepository negotiableInstrumentRepository;
    @Autowired
    private BoletoRepository boletoRepository;
    @Autowired
    private SalesOrderRepository salesOrderRepository;
    @Autowired
    private InvoiceSalesOrderAssociationRepository invoiceSalesOrderAssociationRepository;

    public Invoice execute(Invoice invoice) {
        this.validateInvoice(invoice);
        this.validateAmountInvoiced(invoice);
        invoice.setNegotiableInstruments(this.createNegotiable(invoice));
        if (invoice.getDate() == null) {
            LocalDateTime now = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(now);
            invoice.setDate(timestamp);
            invoice.setDueDate(now.plusDays(30));
            invoice.getNegotiableInstruments().get(0).setDueDate(invoice.getDueDate().plusDays(30));
        }
        Invoice invoice1 = invoiceRepository.save(invoice);
        return invoice1;
    }

    private List<NegotiableInstrument> createNegotiable(Invoice invoice) {
        List<NegotiableInstrument> negotiableInstruments = new ArrayList<>();
        if (invoice.getNegotiableInstruments() == null) {
            NegotiableInstrument negotiableInstrument = new NegotiableInstrument();

            negotiableInstrument.setAmount(invoice.getAmount());
            negotiableInstrument.setCurrency(invoice.getCurrency());
            negotiableInstrument.setState(ExternalPaymentInstructionState.OPEN);
            negotiableInstrument.setDocumentReference("92392992");
            negotiableInstruments.add(negotiableInstrument);
            negotiableInstrument.setExternalReference(invoice.getExternalReference());
            negotiableInstrument.setBoleto(this.createBoleto(negotiableInstrument));

            negotiableInstrumentRepository.save(negotiableInstrument);

        }

        return negotiableInstruments;
    }

    private Boleto createBoleto(NegotiableInstrument negotiableInstrument) {
        LocalDateTime now = LocalDateTime.now();
        if (negotiableInstrument.getBoleto() == null) {
            Boleto boleto = new Boleto();
            boleto.setState(BoletoState.OPEN);
            boleto.setBankReference("341");
            boleto.setDueDate(negotiableInstrument.getDueDate());
            boleto.setDate(negotiableInstrument.getDate());
            boleto.setPaidAmount(negotiableInstrument.getAmount());
            boleto.setAmount(negotiableInstrument.getAmount());
            boleto.setBarCode("23098201213991");
            boleto.setCurrency(negotiableInstrument.getCurrency());
            boleto.setDocumentReference("3442123423");
            boleto.setExternalReference(negotiableInstrument.getExternalReference());
            boleto.setState(BoletoState.OPEN);
            boleto.setPaidDate(now.plusDays(10));
            boletoRepository.save(boleto);
            negotiableInstrument.setBoleto(boleto);
            return boleto;
        }

        return negotiableInstrument.getBoleto();
    }

    public void validateInvoice(Invoice invoice) throws ValidateException {

        Set<Exception> violationExceptions = new LinkedHashSet<>();
        if (invoice.getAmount() == null) {
            violationExceptions.add(new NullValueException("amount"));
        }
        if (invoice.getCurrency() == null) {
            violationExceptions.add(new NullValueException("Currency"));
        }
        if (invoice.getState() == null) {
            violationExceptions.add(new NullValueException("State"));
        }
        if (invoice.getStatus() == null) {
            violationExceptions.add(new NullValueException("Status"));
        }

        if (violationExceptions.size() > 0) {
            throw new ValidateException(violationExceptions, Invoice.class);
        }

    }

    private void validateAmountInvoiced(Invoice invoice){
        if(invoice.getExternalReference() != null){
            Optional<SalesOrder> salesOrders= Optional.of(salesOrderRepository.find
            if(salesOrders.isEmpty() || salesOrders.equals(null)){
                throw new ExternalReferenceNotFoundException(invoice.getExternalReference());
            }
            else{
                InvoiceSalesOrderAssociation association= this.createAssociation(invoice,salesOrders.get());
                BigDecimal invoiceAmount = association.getInvoice().getAmount();
                BigDecimal salesOrderAmount =association.getSalesOrder().getAmount();
                if(invoiceAmount.compareTo(salesOrderAmount) == 1 ){
                    association.getInvoice().setStatus(ExternalPaymentInstructionStatus.EXECUTED);
                }
                else{
                    association.getInvoice().setStatus(ExternalPaymentInstructionStatus.CANCELED);
                    throw new ValueGreaterThanAmountException("Invoice amount is greater than Sales order amount ");
                }
            }
        }


    }

    private InvoiceSalesOrderAssociation createAssociation(Invoice invoice,SalesOrder salesOrder){
        InvoiceSalesOrderAssociation association = new InvoiceSalesOrderAssociation();
        association.setInvoice(invoice);
        association.setSalesOrder(salesOrder);
        association.setAmount(invoice.getAmount());
        association.setDate(LocalDateTime.now());
        invoiceSalesOrderAssociationRepository.save(association);
        return association;
    }

   /* public void execute(Set<SalesOrder> salesOrders, InstructionInvolvement obligor, InstructionInvolvement obligee) {
        SalesOrder currentSalesOrder = new SalesOrder();
        String invoiceSelected = "";
        if (salesOrders != null) {
            Boolean faturarNovamente = true;
            while (faturarNovamente) {
                System.out.println("\n\nDigite qual pedido deseja faturar:");
                invoiceSelected = scan.nextLine();
                Boolean salesOrderExist = false;
                for (SalesOrder sl : salesOrders) {
                    if (sl.getExternalReference().equals(invoiceSelected)) {
                        System.out.println("Pedido encontrado!");
                        System.out.println(sl);
                        currentSalesOrder = sl;
                        salesOrderExist = true;
                    }
                }
                if (!salesOrderExist) {
                    System.out.println("Pedido não foi encontrado! Tente novamente.");

                } else {
                    System.out.println("Valor a ser faturado:");
                    Double value = scan.nextDouble();
                    scan.nextLine();
                    try {
                        discountCreditInstructionInvolvement.execute(obligee, value);
                        System.out.println("Quatidade de parcelas:");
                        Integer qtdParcels = scan.nextInt();
                        Double discountAmount = value / qtdParcels;
                        Invoice invoice = new Invoice();
                        invoice.setDate(LocalDateTime.now());
                        invoice.setAmount(BigDecimal.valueOf(value));
                        invoice.setCurrency(Currency.getInstance("BRL"));
                        invoice.setExternalReference(invoiceSelected);
                        int plusDays= 3;
                        for (int i = 1; i <= qtdParcels; i++) {
                            plusDays+=3;
                            String documentReference = "urn:reference:" + (int) Math.floor(Math.random() * (999999 - 111111 + 1) + 111111);
                            LocalDateTime dueDate = LocalDateTime.now().plusDays(3);
                            NegotiableInstrument negotiable = createNegotiableInstrument.execute(null, documentReference, BigDecimal.valueOf(discountAmount), dueDate.plusDays(plusDays));
                            negotiableInstruments.add(negotiable);
                            Boleto boleto = createBoleto.execute(negotiable);
                            boleto.setBarCode(String.valueOf(1727183193 + (Math.floor(Math.random() * (999999999 - 1111111111 + 1) + 1111111111))));
                            negotiable.setBoleto(boleto);

                        }

                        invoice.setNegotiableInstruments(negotiableInstruments);
                        InvoiceSalesOrderAssociation association = createInvoiceSalesOrderAssociation.execute(invoice, currentSalesOrder);
                        addInvoiceSalesOrderAssociation.execute(associations, salesOrders, association, currentSalesOrder, value);

                        CalculateSalesOrder calculateSalesOrder = new CalculateSalesOrder();
                        Double valueReturned = calculateSalesOrder.execute(currentSalesOrder, salesOrders, invoiceSelected);

                        calculateInvoice.execute(valueReturned, obligee, currentSalesOrder);
                        System.out.println("Obligor credit limit: R$ " + obligee.getCreditLimit());
                        if (obligor.getConfiguration().getSingleInvoicing()) {
                            faturarNovamente = false;
                            System.out.println("Pedido faturado com Sucesso!");
                        } else {
                            scan.nextLine();
                            System.out.println("Deseja sair? S/N");
                            String fazerOutroPedido = scan.nextLine();
                            if (fazerOutroPedido.equalsIgnoreCase("S")) {
                                System.out.println(obligee.getSalesOrders());
                                System.out.println(currentSalesOrder);
                                System.out.println(currentSalesOrder.getInvoiceSalesOrderAssociations());
                                for(NegotiableInstrument ni: negotiableInstruments){
                                    System.out.println(ni);
                                }
                                System.out.println("EC limit: R$" + obligee.getCreditLimit());
                                faturarNovamente = false;
                            } else if (fazerOutroPedido.equalsIgnoreCase("N")) {
                                faturarNovamente = true;
                                System.out.println("Pedido efetuado com sucesso!");
                                for (SalesOrder sl : salesOrders) {
                                    System.out.println(sl);
                                }
                            } else {
                                System.out.println("Opção inválida! Digite 'S' para fazer outro\npedido, e'N' para sair. ");
                            }

                        }
                    } catch (ValueGreaterThanAmountException e) {
                        System.out.println(e.getMessage());
                    } catch (ValueGreaterThanLimitException e) {
                        System.out.println(e.g*//*etMessage());
                    }*/


}
