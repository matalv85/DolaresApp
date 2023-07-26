package dev.matias.DolaresApp.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Component;

import java.net.URL;

@Component
public class StockService {

    public Double getValorStockArs() {

        Double valorStock = 0.0;
        try {

            String ticker = "YPFD.BA";
            // URL de la API
            String apiUrl = "https://query1.finance.yahoo.com/v7/finance/quote?symbols=" + ticker;
            System.out.println(apiUrl);
            // Objeto ObjectMapper de Jackson
            ObjectMapper objectMapper = new ObjectMapper();

            // Obtener el nodo "oficial" de la respuesta JSON
            JsonNode root = objectMapper.readTree(new URL(apiUrl));
            JsonNode quote = root.path("quoteResponse").path("result").get(0);
            valorStock = quote.path("regularMarketPrice").asDouble();


        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return valorStock;
    }

    public Double getValorStockUsd() {

        Double valorStock = 0.0;
        try {

            String ticker = "YPF";
            // URL de la API
            String apiUrl = "https://query1.finance.yahoo.com/v7/finance/quote?symbols=" + ticker;
            // Objeto ObjectMapper de Jackson
            ObjectMapper objectMapper = new ObjectMapper();

            // Obtener el nodo "oficial" de la respuesta JSON
            JsonNode root = objectMapper.readTree(new URL(apiUrl));
            JsonNode quote = root.path("quoteResponse").path("result").get(0);
            valorStock = quote.path("regularMarketPrice").asDouble();


        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return valorStock;
    }

}
