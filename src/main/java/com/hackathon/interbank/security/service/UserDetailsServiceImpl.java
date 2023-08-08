package com.hackathon.interbank.security.service;

import com.hackathon.interbank.security.repository.ClienteRepository;
import com.hackathon.interbank.security.entity.Cliente;
import com.hackathon.interbank.security.entity.ClientePrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    ClienteService clienteService;

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String nombreOrEmail) throws UsernameNotFoundException {
        Cliente cliente = clienteService.getByNombreUsuarioOrEmail(nombreOrEmail).get();
        return ClientePrincipal.build(cliente);

    }


}
