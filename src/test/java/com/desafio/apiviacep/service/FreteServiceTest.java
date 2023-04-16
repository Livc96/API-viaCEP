package com.desafio.apiviacep.service;

import com.desafio.apiviacep.model.Frete;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FreteServiceTest {

    @Test
    void getFrete_ReturnEquals_WhenSudeste() {
        Frete frete = new Frete();
        frete.setFrete("R$7,85");
        String uf = "SP";
        FreteService freteService = new FreteService();

        Assertions.assertEquals(freteService.getFrete(uf).getFrete(), frete.getFrete());
    }

    @Test
    void getFrete_ReturnEquals_WhenCentroOeste() {
        Frete frete = new Frete();
        frete.setFrete("R$12,50");
        String uf = "MS";
        FreteService freteService = new FreteService();

        Assertions.assertEquals(freteService.getFrete(uf).getFrete(), frete.getFrete());
    }

    @Test
    void getFrete_ReturnEquals_WhenNordeste() {
        Frete frete = new Frete();
        frete.setFrete("R$15,98");
        String uf = "CE";
        FreteService freteService = new FreteService();

        Assertions.assertEquals(freteService.getFrete(uf).getFrete(), frete.getFrete());
    }

    @Test
    void getFrete_ReturnEquals_WhenSul() {
        Frete frete = new Frete();
        frete.setFrete("R$17,30");
        String uf = "SC";
        FreteService freteService = new FreteService();

        Assertions.assertEquals(freteService.getFrete(uf).getFrete(), frete.getFrete());
    }

    @Test
    void getFrete_ReturnEquals_WhenNorte() {
        Frete frete = new Frete();
        frete.setFrete("R$20,83");
        String uf = "AM";
        FreteService freteService = new FreteService();

        Assertions.assertEquals(freteService.getFrete(uf).getFrete(), frete.getFrete());
    }


    @Test
    void getFrete_ReturnNotEquals_WhenSudeste() {
        Frete frete = new Frete();
        frete.setFrete("R$15,98");
        String uf = "SP";
        FreteService freteService = new FreteService();

        Assertions.assertNotEquals(freteService.getFrete(uf).getFrete(), frete.getFrete());
    }

    @Test
    void getFrete_ReturnNotEquals_WhenCentroOeste() {
        Frete frete = new Frete();
        frete.setFrete("R$20,83");
        String uf = "MS";
        FreteService freteService = new FreteService();

        Assertions.assertNotEquals(freteService.getFrete(uf).getFrete(), frete.getFrete());
    }

    @Test
    void getFrete_ReturnNotEquals_WhenNordeste() {
        Frete frete = new Frete();
        frete.setFrete("R$7,85");
        String uf = "CE";
        FreteService freteService = new FreteService();

        Assertions.assertNotEquals(freteService.getFrete(uf).getFrete(), frete.getFrete());
    }

    @Test
    void getFrete_ReturnNotEquals_WhenSul() {
        Frete frete = new Frete();
        frete.setFrete("R$7,85");
        String uf = "SC";
        FreteService freteService = new FreteService();

        Assertions.assertNotEquals(freteService.getFrete(uf).getFrete(), frete.getFrete());
    }
    @Test
    void getFrete_ReturnNotEquals_WhenNorte() {
        Frete frete = new Frete();
        frete.setFrete("R$17,30");
        String uf = "AM";
        FreteService freteService = new FreteService();

        Assertions.assertNotEquals(freteService.getFrete(uf).getFrete(), frete.getFrete());
    }
}