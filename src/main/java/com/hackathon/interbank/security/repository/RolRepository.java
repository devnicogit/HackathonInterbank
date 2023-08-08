package com.hackathon.interbank.security.repository;


import com.hackathon.interbank.security.entity.Rol;
import com.hackathon.interbank.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    Optional<Rol> findById(Long id);
    Optional<Rol> findByRolNombre(RolNombre rolNombre);

    List<Rol> findAll();
}
