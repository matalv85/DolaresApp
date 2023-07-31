package dev.matias.DolaresApp.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.matias.DolaresApp.model.Dolar;


@SpringBootTest
public class DolarServiceTest {

    @Autowired
    private DolarService dolarService;

    @Test
    void testGetCompraVentaBlue() {
        Dolar dolar = dolarService.getCompraVentaBlue();
        assertNotEquals(dolar.getCompra(), null);
        assertNotEquals(dolar.getVenta(), null);
        
        

    }

    @Test
    void testGetCompraVentaOficial() {
        Dolar dolar = dolarService.getCompraVentaOficial();
        assertNotEquals(dolar.getCompra(), null);
        assertNotEquals(dolar.getVenta(), null);

    }

    @Test
    void testGetCompraVentaQatar() {
        Dolar dolar = dolarService.getCompraVentaQatar();
        assertNotEquals(dolar.getVenta(), null);

    }
}
