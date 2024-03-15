package com.example.projetotdd.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ComissaoTest {
    
    @Test
    public void calculaComissaoAteMil(){
        Comissao comissao = new Comissao();
        Double valorVenda = 1000.0;
        Double valorComissao = 150.0;

        Double valorCalculado = comissao.calcula(valorVenda);

        Assertions.assertEquals(valorComissao, valorCalculado);
    }

    @Test
    public void calculaComissaoMaisDeMil(){
        Comissao comissao = new Comissao();
        Double valorVenda = 2000.0;
        Double valorComissao = 300.0;

        Double valorCalculado = comissao.calcula(valorVenda);

        Assertions.assertEquals(valorComissao, valorCalculado);
    }
}
