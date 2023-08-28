package com.hackathon.interbank.repository;

import com.hackathon.interbank.swagger.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {
}
