package com.example.projetotdd.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootTest
public class ProdutoTest {

    @TestConfiguration
    static class ProdutoConfiguration {

        @Bean
        public Produto produto() {
            return new Produto();
        }

    }

    @Autowired
    Produto produto;

    @Test
    public void calculaValorTotalProduto() {
        produto.setQuantidade(10);
        produto.setDesconto(10.0);
        produto.setAcrescimo(0.0);
        produto.setValor(10.0);

        double valor = 90.0;

        double valorTotal = produto.calcularValorTotal();

        Assertions.assertEquals(valor, valorTotal);
    }
}
