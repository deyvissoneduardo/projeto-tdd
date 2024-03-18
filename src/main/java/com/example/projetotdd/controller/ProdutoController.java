package com.example.projetotdd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetotdd.model.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    
    @GetMapping()
    public ResponseEntity<List<Produto>> getAll(){
        List<Produto> produtos = new ArrayList<Produto>();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> findById(@PathVariable Long id){
        Optional<Produto> produto = Optional.of(new Produto());
        return ResponseEntity.ok(produto);
    }

    @PostMapping()
    public ResponseEntity<Produto> save(@RequestBody Produto produto){
        return ResponseEntity.ok(produto);
    }
}
