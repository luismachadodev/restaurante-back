package com.example.restauranteback.repository;

import com.example.restauranteback.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByDisponivelTrue();
}
