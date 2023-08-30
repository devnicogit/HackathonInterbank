package com.hackathon.interbank.security.service;


import com.hackathon.interbank.security.repository.UsuarioRepository;
import com.hackathon.interbank.security.repository.RolRepository;
import com.hackathon.interbank.security.entity.Usuario;
import com.hackathon.interbank.security.entity.Rol;
import com.hackathon.interbank.security.entity.dto.NuevoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    RolRepository rolRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    /*public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }*/

    public Optional<Usuario> getByNombre(String nombre){
        return usuarioRepository.findByNombre(nombre);
    }
    public Optional<Usuario> getByNombreUsuarioOrEmail(String nombreOrEmail){
        return usuarioRepository.findByNombreUsuarioOrEmail(nombreOrEmail, nombreOrEmail);
    }

    public Optional<Usuario> getByTokenPassword(String tokenPassword){
        return usuarioRepository.findByTokenPassword(tokenPassword);
    }

    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    /*public void save(Asesor asesor){
        asesorRepository.save(asesor);
    }*/

    public void save(NuevoUsuario nuevoUsuario) {
        Usuario usuario = new Usuario();
        usuario.setNombre(nuevoUsuario.getNombre());
        usuario.setPassword(passwordEncoder.encode(nuevoUsuario.getPassword()));
        usuario.setEmail(nuevoUsuario.getEmail());


        Set<Rol> roles = new HashSet<>();
        for (Long rolId : nuevoUsuario.getRolIds()) {
            Rol rol = rolRepository.findById(rolId)
                    .orElseThrow(() -> new RuntimeException("No se encontró el rol con el ID " + rolId));
            roles.add(rol);
        }
        usuario.setRoles(roles);

        usuarioRepository.save(usuario);
    }


    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll(){return usuarioRepository.findAll();};

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }


    public Optional<Usuario> getByEmail(String mailTo) {
        return usuarioRepository.findByEmail(mailTo);
    }
}
