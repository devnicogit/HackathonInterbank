package com.hackathon.interbank.service;




import com.hackathon.interbank.swagger.entity.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {

    List<Curso> findAll();

    Curso findById(Long id);

    Optional<Curso> findByIds(Long id);

    Curso save(Curso curso);

    Curso update(Long id, Curso curso);


    void delete(Long id);
}
