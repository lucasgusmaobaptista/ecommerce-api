package com.lucasgusmao.ecommerce_api.services;

import com.lucasgusmao.ecommerce_api.models.Carrinho;
import com.lucasgusmao.ecommerce_api.models.Produto;
import com.lucasgusmao.ecommerce_api.repositories.CarrinhoRepository;
import com.lucasgusmao.ecommerce_api.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarrinhoService {

    private CarrinhoRepository carrinhoRepository;
    private ProdutoRepository produtoRepository;

    public CarrinhoService(CarrinhoRepository carrinhoRepository, ProdutoRepository produtoRepository) {
        this.carrinhoRepository = carrinhoRepository;
        this.produtoRepository = produtoRepository;
    }

    public Carrinho adicionarProdutoAoCarrinho(Long idCarrinho, Long idProduto) {
        Carrinho carrinho = carrinhoRepository.findById(idCarrinho)
                .orElseGet(() -> {
                    Carrinho novoCarrinho = new Carrinho();
                    return carrinhoRepository.save(novoCarrinho);
                });
        Produto produto = produtoRepository.findById(idProduto).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produto.setId(idProduto);
        carrinho.getProdutos().add(produto);
        return carrinhoRepository.save(carrinho);
    }

    public List<Produto> listarProdutosNoCarrinho(Long idCarrinho) {
        Carrinho carrinho = carrinhoRepository.findById(idCarrinho).orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
        return new ArrayList<>(carrinho.getProdutos());
    }

    public Carrinho removerProdutoDoCarrinho(Long idCarrinho, Long idProduto) {
        Carrinho carrinho = carrinhoRepository.findById(idCarrinho).orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
        Produto produto = produtoRepository.findById(idProduto).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        carrinho.getProdutos().remove(produto);
        return carrinhoRepository.save(carrinho);
    }

    public void deletarCarrinho(Long idCarrinho) {
        carrinhoRepository.deleteById(idCarrinho);
    }
}

