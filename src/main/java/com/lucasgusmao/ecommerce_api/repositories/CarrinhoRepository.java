package com.lucasgusmao.ecommerce_api.repositories;

import com.lucasgusmao.ecommerce_api.models.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
}
