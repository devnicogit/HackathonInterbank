package com.hackathon.interbank.service;




import com.hackathon.interbank.swagger.entity.Curso;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Curso> findAll();

    Curso findById(Long id);

    Optional<Curso> findByIds(Long id);

    Curso save(Curso producto);

    Curso update(Long id, Curso producto);


    void delete(Long id);
}
