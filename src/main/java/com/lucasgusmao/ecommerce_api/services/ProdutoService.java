package com.lucasgusmao.ecommerce_api.services;

import com.lucasgusmao.ecommerce_api.models.Produto;
import com.lucasgusmao.ecommerce_api.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> verProdutos() {
        return repository.findAll();
    }

    public Optional<Produto> verProdutoPorId(Long id) {
        return repository.findById(id);
    }

    public Produto criarProduto(Produto produto) {
        return repository.save(produto);
    }

    public Produto atualizarProduto(Long id, Produto produto) {
        Optional<Produto> produtoExistente = repository.findById(id);
        if (produtoExistente.isPresent()) {
            Produto p = produtoExistente.get();
            p.setName(produto.getName());
            p.setDescription(produto.getDescription());
            p.setPrice(produto.getPrice());
            return repository.save(p);
        } else {
            throw new RuntimeException("Produto com o ID " + id + " não encontrado!");
        }
    }

    public void removerProdutoPorId(Long id) {
        repository.deleteById(id);
    }
}
