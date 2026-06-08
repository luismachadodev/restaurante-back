package com.example.restauranteback.service;

import com.example.restauranteback.dto.ItemPedidoDTO;
import com.example.restauranteback.dto.PedidoDTO;
import com.example.restauranteback.entity.ItemPedido;
import com.example.restauranteback.entity.Pedido;
import com.example.restauranteback.entity.Produto;
import com.example.restauranteback.repository.ItemPedidoRepository;
import com.example.restauranteback.repository.PedidoRepository;
import com.example.restauranteback.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;
    private final ItemPedidoRepository itemPedidoRepository;

    @Transactional
    public Pedido finalizarCompra(PedidoDTO pedidoDTO) {

        BigDecimal valorTotal = BigDecimal.ZERO;

        Pedido pedido = new Pedido();
        pedido.setDataPedido(LocalDateTime.now());

        pedido = pedidoRepository.save(pedido);

        for (ItemPedidoDTO item : pedidoDTO.itens()) {

            Produto produto = produtoRepository
                    .findById(item.produtoId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            valorTotal = valorTotal.add(
                    produto.getPreco()
                            .multiply(
                                    BigDecimal.valueOf(
                                            item.quantidade()
                                    )
                            )
            );

            ItemPedido itemPedido = new ItemPedido();

            itemPedido.setPedido(pedido);
            itemPedido.setProduto(produto);
            itemPedido.setQuantidade(item.quantidade());

            itemPedidoRepository.save(itemPedido);
        }

        pedido.setValorTotal(valorTotal);

        return pedidoRepository.save(pedido);
    }
}
