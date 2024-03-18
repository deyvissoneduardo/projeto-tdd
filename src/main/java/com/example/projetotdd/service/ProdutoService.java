package com.example.projetotdd.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.projetotdd.model.Produto;

@Service
public class ProdutoService {

    public List<Produto> getAll(){
        List<Produto> produtos = new ArrayList<Produto>();
        return produtos;
    }

    public Optional<Produto> findById(Long id){
        Optional<Produto> produto = Optional.of(new Produto());
        return produto;
    }

    public Produto save(Produto produto){
        return produto;
    }
}
