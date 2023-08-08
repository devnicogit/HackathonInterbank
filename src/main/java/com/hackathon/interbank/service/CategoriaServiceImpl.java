package com.hackathon.interbank.service;


import com.hackathon.interbank.repository.CategoriaRepository;
import com.hackathon.interbank.swagger.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Optional<Categoria> findByIds(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria update(Long id, Categoria categoria) {
        Categoria categoriaEncontrada = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la categoría con el ID " + id));

        categoriaEncontrada.setNombre(categoria.getNombre());
        categoriaEncontrada.setDescripcion(categoria.getDescripcion());

        return categoriaRepository.save(categoriaEncontrada);
    }


    @Override
    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }
}
