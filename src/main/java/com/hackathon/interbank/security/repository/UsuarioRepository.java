package com.hackathon.interbank.security.repository;




import com.hackathon.interbank.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findById(Long id);
    /*Optional<Usuario> findById(Integer id);*/
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    Optional<Usuario> findByNombreUsuarioOrEmail(String nombreUsuario, String email);
    Optional<Usuario> findByTokenPassword(String tokenPassword);
    Optional<Usuario> findByEmail(String mailTo);
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);

    List<Usuario> findAll();




}
