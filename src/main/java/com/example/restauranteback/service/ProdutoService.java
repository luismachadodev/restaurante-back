package com.example.restauranteback.service;

import com.example.restauranteback.entity.Produto;
import com.example.restauranteback.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarTodosProdutos() {
        return produtoRepository.findAll();
    }

    public List<Produto> listarProdutosAtivos() {
        return produtoRepository.findByDisponivelTrue();
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void excluirProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
