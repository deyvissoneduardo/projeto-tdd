package com.example.projetotdd.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.projetotdd.model.Produto;
import com.example.projetotdd.service.ProdutoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class ProdutoControllerTest {
    
    @Autowired
    private ProdutoController controller;

    @MockBean
    private ProdutoService service;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getAllTest() throws Exception{
        List<Produto> produtos = new  ArrayList<Produto>();
        
        var request = MockMvcRequestBuilders.get("/api/produto");
        
        when(this.service.getAll()).thenReturn(produtos);

        this.mockMvc.perform(request)
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getFindByIdTest() throws Exception{
        Produto produto = new Produto();
        produto.setId(2L);
        produto.setNome("Teste");
        produto.setQuantidade(50);
        produto.setValor(10.0);
        produto.setAcrescimo(5.0);
        produto.setDesconto(0.1);

        Optional<Produto> opt = Optional.of(produto);
        
        var request = MockMvcRequestBuilders.get("/api/produto/2");
        
        when(this.service.findById(2l)).thenReturn(opt);

        this.mockMvc.perform(request)
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(2l));
    }


    @SuppressWarnings("null")
    @Test
    public void saveTest() throws Exception{
        Produto produto = new Produto();
        produto.setNome("Teste");
        produto.setQuantidade(50);
        produto.setValor(10.0);
        produto.setAcrescimo(5.0);
        produto.setDesconto(0.1);

        
        String json = new ObjectMapper().writeValueAsString(produto);

        var request = MockMvcRequestBuilders.post("/api/produto/")
        .content(json)
        .contentType(MediaType.APPLICATION_JSON);

        produto.setId(3l);
        
        when(this.service.save(produto)).thenReturn(produto);

        this.mockMvc.perform(request)
            .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}
