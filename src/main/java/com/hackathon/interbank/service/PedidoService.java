package com.hackathon.interbank.service;



import com.hackathon.interbank.swagger.entity.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {

    List<Pedido> findAll();

    Pedido findById(Long id);

    Optional<Pedido> findByIds(Long id);

    Pedido save(Pedido pedido);

    Pedido update(Long id, Pedido pedido);


    void delete(Long id);
}
