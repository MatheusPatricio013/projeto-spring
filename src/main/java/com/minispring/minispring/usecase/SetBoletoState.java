package com.minispring.minispring.usecase;

import com.minispring.minispring.model.BoletoState;

public class SetBoletoState {
    public BoletoState execute(String statusTitulo) {
        return switch (statusTitulo) {
            case "A VENCER" -> BoletoState.OPEN;
            case "NO PRAZO" -> BoletoState.PAID;
            case "FORA DO PRAZO" -> BoletoState.PAID;
            case "VENCIDO" -> BoletoState.OVERDUE;
            default -> throw new RuntimeException(statusTitulo);
        };
    }
}