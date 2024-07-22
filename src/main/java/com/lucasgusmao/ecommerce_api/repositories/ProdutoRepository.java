package com.lucasgusmao.ecommerce_api.repositories;

import com.lucasgusmao.ecommerce_api.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
