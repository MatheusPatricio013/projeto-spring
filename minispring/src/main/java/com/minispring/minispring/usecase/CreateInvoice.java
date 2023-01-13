package com.minispring.minispring.usecase;

import com.minispring.minispring.exception.ValueGreaterThanAmountException;
import com.minispring.minispring.exception.ValueGreaterThanLimitException;
import com.minispring.minispring.model.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class CreateInvoice {
    private final CreateNegotiableInstrument createNegotiableInstrument = new CreateNegotiableInstrument();
    private final List<NegotiableInstrument> negotiableInstruments = new ArrayList<>();
    private final DiscountCreditInstructionInvolvement discountCreditInstructionInvolvement = new DiscountCreditInstructionInvolvement();
    private final ValidateValueInvoice validateValueInvoice = new ValidateValueInvoice();
    private final AddInvoiceSalesOrderAssociation addInvoiceSalesOrderAssociation = new AddInvoiceSalesOrderAssociation();
    private final CreateInvoiceSalesOrderAssociation createInvoiceSalesOrderAssociation = new CreateInvoiceSalesOrderAssociation();
    private final CalculateInvoice calculateInvoice = new CalculateInvoice();
    private final SalesOrder currentSalesOder = new SalesOrder();
    private final Set<InvoiceSalesOrderAssociation> associations = new HashSet<>();
    private final Scanner scan = new Scanner(System.in);
    CreateBoleto createBoleto = new CreateBoleto();

    public void execute(Set<SalesOrder> salesOrders, InstructionInvolvement obligor, InstructionInvolvement obligee) {
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
                        System.out.println(e.getMessage());
                    }

                }

            }
        }
    }
}
