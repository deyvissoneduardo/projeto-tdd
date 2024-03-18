package com.example.projetotdd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetotdd.model.Produto;
import com.example.projetotdd.service.ProdutoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;
    
    @GetMapping()
    public ResponseEntity<List<Produto>> getAll(){
        List<Produto> produtos = service.getAll();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> findById(@PathVariable Long id){
        Optional<Produto> produto = service.findById(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Produto> save(@RequestBody Produto produto){
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }
}
