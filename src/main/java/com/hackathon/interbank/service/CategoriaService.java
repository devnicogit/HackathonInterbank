package com.hackathon.interbank.service;

import com.hackathon.interbank.swagger.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    List<Categoria> findAll();

    Categoria findById(Long id);


    Categoria save(Categoria categoria);

    Optional<Categoria> findByIds(Long id);

    Categoria update(Long id, Categoria categoria);

    //List<Categoria> findByCategoria(Categoria categoria);

    void delete(Long id);
}

