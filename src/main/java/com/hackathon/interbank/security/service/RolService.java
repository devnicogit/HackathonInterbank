package com.hackathon.interbank.security.service;

import com.hackathon.interbank.security.entity.Rol;
import com.hackathon.interbank.security.enums.RolNombre;
import com.hackathon.interbank.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getById(Long id){ return rolRepository.findById(id);}

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }

    public List<Rol> findAll(){return rolRepository.findAll();};
}
