package com.example.projetotdd.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootTest
public class ComissaoTest {

    @TestConfiguration
    static class ComissaoConfiguration {

        @Bean
        public Comissao comissao(){
         return   new Comissao();
        }
        
    }

    @Autowired
    Comissao comissao;
    
    @Test
    public void calculaComissaoAteMil(){
        Double valorVenda = 1000.0;
        Double valorComissao = 150.0;

        Double valorCalculado = comissao.calcula(valorVenda);

        Assertions.assertEquals(valorComissao, valorCalculado);
    }

    @Test
    public void calculaComissaoMaisDeMil(){
        Double valorVenda = 2000.0;
        Double valorComissao = 300.0;

        Double valorCalculado = comissao.calcula(valorVenda);

        Assertions.assertEquals(valorComissao, valorCalculado);
    }
}
