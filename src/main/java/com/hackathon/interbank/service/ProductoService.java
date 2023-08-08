package com.hackathon.interbank.service;




import com.hackathon.interbank.swagger.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> findAll();

    Producto findById(Long id);

    Optional<Producto> findByIds(Long id);

    Producto save(Producto producto);

    Producto update(Long id, Producto producto);


    void delete(Long id);
}
