package com.hackathon.interbank.service;



import com.hackathon.interbank.swagger.entity.Clientes;

import java.util.List;
import java.util.Optional;

public interface ClientesService {

    List<Clientes> findAll();

    Clientes findById(Long id);


    Clientes save(Clientes clientes);

    Optional<Clientes> findByIds(Long id);

    Clientes update(Long id, Clientes clientes);

    //List<Categoria> findByCategoria(Categoria categoria);

    void delete(Long id);
}
