package com.hackathon.interbank.service;


import com.hackathon.interbank.repository.CategoriaRepository;
import com.hackathon.interbank.repository.CursoRepository;
import com.hackathon.interbank.swagger.entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso findById(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public Optional<Curso> findByIds(Long id) {
        return cursoRepository.findById(id);
    }

    @Override
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso update(Long id, Curso curso) {

        Curso existingCurso = cursoRepository.findById(id).orElse(null);
        if (existingCurso == null) {
            return null;
        }
        existingCurso.setNombre(curso.getNombre());
        existingCurso.setDescripcion(curso.getDescripcion());
        existingCurso.setCategoria(curso.getCategoria());
        existingCurso.setImagen(curso.getImagen());
        existingCurso.setPrecio(curso.getPrecio());

        Curso updatedCurso = cursoRepository.save(existingCurso);
        return updatedCurso;
    }

    @Override
    public void delete(Long id) {
        cursoRepository.deleteById(id);
    }
}
