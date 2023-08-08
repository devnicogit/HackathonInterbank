package com.hackathon.interbank.service;



import com.hackathon.interbank.dto.CuponDto;
import com.hackathon.interbank.swagger.entity.Cupon;
import com.hackathon.interbank.swagger.entity.Pedido;

import java.util.List;
import java.util.Optional;

public interface CuponService {
    List<Cupon> findAll();

    Cupon findById(Long id);


    Cupon save(Cupon cupon);

    Optional<Cupon> findByIds(Long id);
    Cupon update(Long id, Cupon cupon);


    void delete(Long id);
}
