package com.example.restauranteback.controller;

import com.example.restauranteback.dto.PedidoDTO;
import com.example.restauranteback.entity.Pedido;
import com.example.restauranteback.entity.Produto;
import com.example.restauranteback.service.PedidoService;
import com.example.restauranteback.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PedidoController {

    private final PedidoService pedidoService;
    private final ProdutoService produtoService;

    @PostMapping("/finalizar")
    public Pedido finalizarCompra(@RequestBody PedidoDTO pedidoDTO) {
        return pedidoService.finalizarCompra(pedidoDTO);

    }

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    @GetMapping("/disponiveis")
    public List<Produto> listarProdutosDisponiveis() {
        return produtoService.listarProdutosAtivos();
    }
}
