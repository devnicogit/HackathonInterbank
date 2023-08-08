package com.hackathon.interbank.security.repository;




import com.hackathon.interbank.security.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findById(Long id);
    /*Optional<Usuario> findById(Integer id);*/
    Optional<Cliente> findByNombreUsuario(String nombreUsuario);
    Optional<Cliente> findByNombreUsuarioOrEmail(String nombreUsuario, String email);
    Optional<Cliente> findByTokenPassword(String tokenPassword);
    Optional<Cliente> findByEmail(String mailTo);
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);

    List<Cliente> findAll();




}
