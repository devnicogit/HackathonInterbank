package com.hackathon.interbank.service;


import com.hackathon.interbank.repository.CategoriaRepository;
import com.hackathon.interbank.repository.ProductoRepository;
import com.hackathon.interbank.swagger.entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Curso> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Curso findById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Optional<Curso> findByIds(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Curso save(Curso producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Curso update(Long id, Curso producto) {

        Curso existingProducto = productoRepository.findById(id).orElse(null);
        if (existingProducto == null) {
            return null;
        }
        existingProducto.setNombre(producto.getNombre());
        existingProducto.setDescripcion(producto.getDescripcion());
        existingProducto.setCategoria(producto.getCategoria());
        existingProducto.setIgv(producto.getIgv());
        existingProducto.setImagen(producto.getImagen());
        existingProducto.setPrecio(producto.getPrecio());
        existingProducto.setDescuento(producto.getDescuento());

        Curso updatedProducto = productoRepository.save(existingProducto);
        return updatedProducto;
    }

    @Override
    public void delete(Long id) {
        productoRepository.deleteById(id);
    }
}
