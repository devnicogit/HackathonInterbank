package com.hackathon.interbank.service;


import com.hackathon.interbank.repository.ClientesRepository;
import com.hackathon.interbank.repository.CuponRepository;
import com.hackathon.interbank.repository.EstadoPedidoRepository;
import com.hackathon.interbank.repository.PedidoRepository;
import com.hackathon.interbank.security.repository.UsuarioRepository;
import com.hackathon.interbank.swagger.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClientesRepository clienteRepository;

    @Autowired
    private EstadoPedidoRepository estadoPedidoRepository;

    @Autowired
    private CuponRepository cuponRepository;

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido findById(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @Override
    public Optional<Pedido> findByIds(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido update(Long id, Pedido pedido) {
        Pedido existingPedido = pedidoRepository.findById(id).orElse(null);
        if (existingPedido == null) {
            return null;
        }
        existingPedido.setFecha(pedido.getFecha());
        existingPedido.setSubtotal(pedido.getSubtotal());
        existingPedido.setIgv(pedido.getIgv());
        existingPedido.setTotal(pedido.getTotal());
        existingPedido.setCliente(pedido.getCliente());
        existingPedido.setEstado(pedido.getEstado());
        existingPedido.setCupon(pedido.getCupon());

        Pedido updatedPedido = pedidoRepository.save(existingPedido);
        return updatedPedido;
    }

    @Override
    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }
}
