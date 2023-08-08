package com.hackathon.interbank.security.service;


import com.hackathon.interbank.security.repository.ClienteRepository;
import com.hackathon.interbank.security.repository.RolRepository;
import com.hackathon.interbank.security.entity.Cliente;
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
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    RolRepository rolRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Optional<Cliente> getByNombreUsuario(String nombreUsuario){
        return clienteRepository.findByNombreUsuario(nombreUsuario);
    }

    public Optional<Cliente> getByNombreUsuarioOrEmail(String nombreOrEmail){
        return clienteRepository.findByNombreUsuarioOrEmail(nombreOrEmail, nombreOrEmail);
    }

    public Optional<Cliente> getByTokenPassword(String tokenPassword){
        return clienteRepository.findByTokenPassword(tokenPassword);
    }

    public boolean existsByNombreUsuario(String nombreUsuario){
        return clienteRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email){
        return clienteRepository.existsByEmail(email);
    }

    /*public void save(Asesor asesor){
        asesorRepository.save(asesor);
    }*/

    public void save(NuevoUsuario nuevoUsuario) {
        Cliente cliente = new Cliente();
        cliente.setNombre(nuevoUsuario.getNombre());
        cliente.setNombreUsuario(nuevoUsuario.getNombreUsuario());
        cliente.setPassword(passwordEncoder.encode(nuevoUsuario.getPassword()));
        cliente.setEmail(nuevoUsuario.getEmail());


        Set<Rol> roles = new HashSet<>();
        for (Long rolId : nuevoUsuario.getRolIds()) {
            Rol rol = rolRepository.findById(rolId)
                    .orElseThrow(() -> new RuntimeException("No se encontró el rol con el ID " + rolId));
            roles.add(rol);
        }
        cliente.setRoles(roles);

        clienteRepository.save(cliente);
    }


    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public List<Cliente> findAll(){return clienteRepository.findAll();};

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }


    public Optional<Cliente> getByEmail(String mailTo) {
        return clienteRepository.findByEmail(mailTo);
    }
}
