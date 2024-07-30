package com.lucasgusmao.ecommerce_api.controllers;

import com.lucasgusmao.ecommerce_api.models.Produto;
import com.lucasgusmao.ecommerce_api.services.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produto> verProdutos() {
        List<Produto> produtos = service.verProdutos();
        return produtos;
    }

    @GetMapping("/{id}")
    public Optional<Produto> verProdutoPorId(@PathVariable Long id) {
        return service.verProdutoPorId(id);
    }

    @PostMapping("/criar")
    public Produto criarProduto(@RequestBody Produto produto) {
        return service.criarProduto(produto);
    }

    @PutMapping("/atualizar/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        Produto p = service.atualizarProduto(id, produto);
        return p;
    }

    @DeleteMapping("/remover/{id}")
    public String removerProduto(@PathVariable Long id) {
        service.removerProdutoPorId(id);
        return "Produto removido com sucesso.";
    }
}
