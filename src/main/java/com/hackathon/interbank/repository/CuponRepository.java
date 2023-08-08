package com.hackathon.interbank.repository;


import com.hackathon.interbank.swagger.entity.Cupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuponRepository extends JpaRepository<Cupon, Long> {
}
