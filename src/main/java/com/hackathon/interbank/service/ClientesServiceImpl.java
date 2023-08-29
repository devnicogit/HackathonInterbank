package com.hackathon.interbank.service;

import com.hackathon.interbank.repository.ClientesRepository;
import com.hackathon.interbank.swagger.entity.Categoria;
import com.hackathon.interbank.swagger.entity.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesServiceImpl implements ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;
    @Override
    public List<Clientes> findAll() {
        return clientesRepository.findAll();
    }

    @Override
    public Clientes findById(Long id) {
        return clientesRepository.findById(id).orElse(null);
    }

    @Override
    public Clientes save(Clientes clientes) {
        return clientesRepository.save(clientes);
    }

    @Override
    public Optional<Clientes> findByIds(Long id) {
        return clientesRepository.findById(id);
    }

    @Override
    public Clientes update(Long id, Clientes clientes) {
        Clientes clienteEncontrado = clientesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el cliente con el ID " + id));

        clienteEncontrado.setDireccion(clientes.getDireccion());
        clienteEncontrado.setNumPedidos(clientes.getNumPedidos());
        clienteEncontrado.setUsuario(clientes.getUsuario());
        clienteEncontrado.setCarritos(clientes.getCarritos());
        clienteEncontrado.setPedidos(clientes.getPedidos());

        return clientesRepository.save(clienteEncontrado);
    }

    @Override
    public void delete(Long id) {
        clientesRepository.deleteById(id);
    }
}
