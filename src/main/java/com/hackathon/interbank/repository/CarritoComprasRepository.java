package com.hackathon.interbank.repository;


import com.hackathon.interbank.swagger.entity.CarritoCompras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoComprasRepository extends JpaRepository<CarritoCompras, Long> {
}
