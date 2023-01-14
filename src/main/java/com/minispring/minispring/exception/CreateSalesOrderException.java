package com.minispring.minispring.exception;

public class CreateSalesOrderException extends  RuntimeException{
    public CreateSalesOrderException(){
        System.out.println("Erro ao criar pedido! Verifique se as informações\nforam colocadas corretamente");
    }
}
