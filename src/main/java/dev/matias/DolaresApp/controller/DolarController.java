package dev.matias.DolaresApp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.matias.DolaresApp.model.Dolar;
import dev.matias.DolaresApp.service.DolarService;
import dev.matias.DolaresApp.service.StockService;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;

@RestController
public class DolarController {

    private DolarService dolarService;
    private StockService stockService;

    public DolarController(DolarService dolarService, StockService stockService) {
        this.dolarService = dolarService;
        this.stockService = stockService;
    }

    @GetMapping("/")
    public String homeController(){
        return "Bienvenidos a Dolar App";
    }
    //@PreAuthorize("hasRole('USER')")
    @GetMapping("/api/dolares/oficial")
    public String dolarOficial(){
        Dolar dolar = dolarService.getCompraVentaOficial();

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writeValueAsString(dolar);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return json;
    }

    //@PreAuthorize("hasRole('USER')")
    @GetMapping("/api/dolares/qatar")
    public String dolarQatar(){
        Dolar dolar = dolarService.getCompraVentaQatar();

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writeValueAsString(dolar);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return json;
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/api/dolares/blue")
    public String dolarBlue(){
        Dolar dolar = dolarService.getCompraVentaBlue();

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writeValueAsString(dolar);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return json;
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/api/dolares/ccl")
    public String dolarCCL(){

        Double diferenciaValorArsUsd = stockService.getValorStockArs() / stockService.getValorStockUsd();
        DecimalFormat df = new DecimalFormat("#.##");
        String diferenciaConDosDigitos = df.format(diferenciaValorArsUsd).replace(',','.');
        //diferenciaConDosDigitos.replace(',','.');

        try {
            Double doubleConDosDigitos = df.parse(diferenciaConDosDigitos).doubleValue();
        } catch (Exception e){
            System.out.println("Error");
        }
        Dolar dolar = new Dolar("Dolar CCL", null, Double.valueOf(diferenciaConDosDigitos));

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writeValueAsString(dolar);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return json;

    }
}
