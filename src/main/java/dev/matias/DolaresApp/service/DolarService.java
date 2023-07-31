package dev.matias.DolaresApp.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.matias.DolaresApp.model.Dolar;
import dev.matias.DolaresApp.model.Impuestos;
import org.springframework.stereotype.Component;
import java.net.URL;

@Component
public class DolarService {

    public Dolar getCompraVentaOficial() {

        Dolar dolar = null;
        try {


            // URL de la API
            String apiUrl = "https://api.bluelytics.com.ar/v2/latest";

            // Objeto ObjectMapper de Jackson
            ObjectMapper objectMapper = new ObjectMapper();

            // Obtener el nodo "oficial" de la respuesta JSON
            JsonNode rootNode = objectMapper.readTree(new URL(apiUrl));
            JsonNode oficialNode = rootNode.get("oficial");

            // Obtener los valores de  "value_sell" y "value_buy" del nodo "oficial"
            double valorVenta = oficialNode.get("value_sell").asDouble();
            double valorCompra = oficialNode.get("value_buy").asDouble();

            dolar = new Dolar("Dolar oficial", valorCompra, valorVenta);

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return dolar;
    }

    public Dolar getCompraVentaQatar(){
        Dolar dolarOficial = getCompraVentaOficial();

        Double impuestoPais = dolarOficial.getVenta() * Impuestos.PAIS.getTotalImpuesto() / 100;
        Double impuestoGanancias = dolarOficial.getVenta() * Impuestos.GANANCIAS.getTotalImpuesto() / 100;
        Double impuestoBienesPersonales = dolarOficial.getVenta() * Impuestos.BIENES_PERSONALES.getTotalImpuesto() / 100;

        Double valorVenta =  dolarOficial.getVenta() + impuestoPais + impuestoGanancias + impuestoBienesPersonales;

        return new Dolar("Dolar Qatar", null, valorVenta);
    }

    public Dolar getCompraVentaBlue() {

        Dolar dolar = null;
        try {


            // URL de la API
            String apiUrl = "https://api.bluelytics.com.ar/v2/latest";

            // Objeto ObjectMapper de Jackson
            ObjectMapper objectMapper = new ObjectMapper();

            // Obtener el nodo "oficial" de la respuesta JSON
            JsonNode rootNode = objectMapper.readTree(new URL(apiUrl));
            JsonNode oficialNode = rootNode.get("blue");

            // Obtener los valores de  "value_sell" y "value_buy" del nodo "oficial"
            double valorVenta = oficialNode.get("value_sell").asDouble();
            double valorCompra = oficialNode.get("value_buy").asDouble();

            dolar = new Dolar("blue", valorCompra, valorVenta);

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return dolar;
    }
}