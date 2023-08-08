package com.hackathon.interbank.service;



import com.hackathon.interbank.repository.CuponRepository;
import com.hackathon.interbank.swagger.entity.Cupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuponServiceImpl implements CuponService{

    @Autowired
    private CuponRepository cuponRepository;

    @Override
    public List<Cupon> findAll() {
        return cuponRepository.findAll();
    }

    @Override
    public Cupon findById(Long id) {
        return cuponRepository.findById(id).orElse(null);
    }

    @Override
    public Cupon save(Cupon cupon) {
        return cuponRepository.save(cupon);
    }

    @Override
    public Optional<Cupon> findByIds(Long id) {
        return cuponRepository.findById(id);
    }

    @Override
    public Cupon update(Long id, Cupon cupon) {
        Cupon cuponEncontrado = cuponRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el cupón con el ID " + id));

        cuponEncontrado.setCodigo(cupon.getCodigo());
        cuponEncontrado.setDescripcion(cupon.getDescripcion());
        cuponEncontrado.setDescuento(cupon.getDescuento());


        return cuponRepository.save(cuponEncontrado);
    }

    @Override
    public void delete(Long id) {
        cuponRepository.deleteById(id);
    }
}
