package com.hackathon.interbank.repository;

import com.hackathon.interbank.swagger.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Curso, Long> {
}
