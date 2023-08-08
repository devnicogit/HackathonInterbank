package com.hackathon.interbank.service;


import com.hackathon.interbank.dto.EstadoPedidoDto;
import com.hackathon.interbank.repository.EstadoPedidoRepository;
import com.hackathon.interbank.swagger.entity.EstadoPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoPedidoServiceImpl implements EstadoPedidoService{

    @Autowired
    private EstadoPedidoRepository estadoPedidoRepository;
    @Override
    public List<EstadoPedido> findAll() {
        return estadoPedidoRepository.findAll();
    }

    @Override
    public EstadoPedido findById(Long id) {
        return estadoPedidoRepository.findById(id).orElse(null);
    }

    @Override
    public EstadoPedido save(EstadoPedido estadoPedido) {
        return estadoPedidoRepository.save(estadoPedido);
    }

    @Override
    public Optional<EstadoPedido> findByIds(Long id) {
        return estadoPedidoRepository.findById(id);
    }

    @Override
    public EstadoPedido update(Long id, EstadoPedido estadoPedido) {
        EstadoPedido estadoPedidoEncontrado = estadoPedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el Estado de Pedido con el ID " + id));

        estadoPedidoEncontrado.setDescripcion(estadoPedido.getDescripcion());

        return estadoPedidoRepository.save(estadoPedidoEncontrado);
    }

    @Override
    public void delete(Long id) {
        estadoPedidoRepository.deleteById(id);
    }
}
