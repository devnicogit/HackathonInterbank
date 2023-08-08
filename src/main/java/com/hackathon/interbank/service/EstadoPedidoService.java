package com.hackathon.interbank.service;







import com.hackathon.interbank.swagger.entity.EstadoPedido;


import java.util.List;
import java.util.Optional;

public interface EstadoPedidoService {

    List<EstadoPedido> findAll();

    EstadoPedido findById(Long id);


    EstadoPedido save(EstadoPedido estadoPedido);

    Optional<EstadoPedido> findByIds(Long id);


    EstadoPedido update(Long id, EstadoPedido estadoPedido);

    //List<Categoria> findByCategoria(Categoria categoria);

    void delete(Long id);
}
