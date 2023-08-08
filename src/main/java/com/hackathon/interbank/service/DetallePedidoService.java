package com.hackathon.interbank.service;



import com.hackathon.interbank.swagger.entity.DetallePedido;

import java.util.List;

public interface DetallePedidoService {

    List<DetallePedido> findAll();


    DetallePedido findById(Long id);

    DetallePedido save(DetallePedido detallePedido);
}
