package com.hackathon.interbank.service;

import com.hackathon.interbank.repository.DetallePedidoRepository;
import com.hackathon.interbank.swagger.entity.DetallePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService{

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;
    @Override
    public List<DetallePedido> findAll() {
        return detallePedidoRepository.findAll();
    }

    @Override
    public DetallePedido findById(Long id) {
        return detallePedidoRepository.findById(id).orElse(null);
    }

    @Override
    public DetallePedido save(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }
}
