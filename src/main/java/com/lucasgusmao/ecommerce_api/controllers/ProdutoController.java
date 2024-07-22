package com.lucasgusmao.ecommerce_api.controllers;

import com.lucasgusmao.ecommerce_api.models.Produto;
import com.lucasgusmao.ecommerce_api.services.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public List<Produto> listProducts() {
        return service.listarProdutos();
    }

    @PostMapping(   "/criar")
    public Produto createProduct(@RequestBody Produto produto) {
        return service.criarProduto(produto);
    }

    @DeleteMapping("/deletar/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.deletarProduto(id);
    }
}
