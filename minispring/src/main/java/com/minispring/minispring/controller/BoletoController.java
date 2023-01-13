package com.minispring.minispring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minispring.minispring.model.Boleto;
import com.minispring.minispring.repository.BoletoRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
@Log4j2
@RestController
public class BoletoController {
    @Autowired
    private BoletoRepository boletoRepository;

    @PostMapping(path = "/criarBoleto")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody  Boleto criarBoleto(@RequestBody Boleto boleto) throws JsonProcessingException {
        boletoRepository.save(boleto);
        return boleto;
    }


    @GetMapping(path ="/retrieve-boletos")
    @ResponseStatus(HttpStatus.OK)
    public String retrieveBoleto(){
        List<Boleto> boletos = boletoRepository.findAll().stream().toList();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(boletos)    ;
        } catch (JsonProcessingException e) {
            log.error(e.getMessage() + e.getStackTrace());
        }
        return "Erro ao exibir boletos!"+ this.getClass().getName();
    }


    }
