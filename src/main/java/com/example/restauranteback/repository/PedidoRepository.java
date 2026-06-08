package com.example.restauranteback.repository;

import com.example.restauranteback.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
}
