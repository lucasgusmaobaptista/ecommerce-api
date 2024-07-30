package com.lucasgusmao.ecommerce_api.controllers;


import com.lucasgusmao.ecommerce_api.models.Carrinho;
import com.lucasgusmao.ecommerce_api.models.Produto;
import com.lucasgusmao.ecommerce_api.services.CarrinhoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    private CarrinhoService carrinhoService;

    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @GetMapping("/{idCarrinho}/produtos")
    public ResponseEntity<List<Produto>> listarProdutosNoCarrinho(@PathVariable Long idCarrinho) {
        List<Produto> produtos = carrinhoService.listarProdutosNoCarrinho(idCarrinho);
        return  ResponseEntity.ok(produtos);
    }
    @PostMapping("/add/{idCarrinho}/produto/{idProduto}")
    public ResponseEntity<Carrinho> adicionarProdutoAoCarrinho(@PathVariable Long idCarrinho, @PathVariable Long idProduto) {
        Carrinho carrinhoAtualizado = carrinhoService.adicionarProdutoAoCarrinho(idCarrinho, idProduto);
        return ResponseEntity.ok(carrinhoAtualizado);
    }

    @DeleteMapping("/remove/{idCarrinho}/produto/{idProduto}")
    public ResponseEntity<Carrinho> removerProdutoDoCarrinho(@PathVariable Long idCarrinho, @PathVariable Long idProduto) {
        Carrinho carrinhoAtualizado = carrinhoService.removerProdutoDoCarrinho(idCarrinho, idProduto);
        return ResponseEntity.ok(carrinhoAtualizado);
    }

    @DeleteMapping("/delete/{idCarrinho}")
    public ResponseEntity<String> deletarCarrinho(@PathVariable Long idCarrinho) {
        carrinhoService.deletarCarrinho(idCarrinho);
        return ResponseEntity.ok("Carrinho deletado com sucesso.");
    }

}
