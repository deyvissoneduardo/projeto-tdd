package com.example.projetotdd.model;

public class Comissao {
    public Double calcula(Double valorVenda) {
        return valorVenda >= 1000.0 ? valorVenda * 0.15 :valorVenda * 0.10; 
    }
}
