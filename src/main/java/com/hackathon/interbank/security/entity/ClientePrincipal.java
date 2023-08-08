package com.hackathon.interbank.security.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ClientePrincipal implements UserDetails {

    private Long id;
    private String nombre;

    private String nombreUsuario;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public ClientePrincipal(String nombre, String email, String nombreUsuario, String password, Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.email = email;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.authorities = authorities;
    }

    public static ClientePrincipal build(Cliente cliente){
        List<GrantedAuthority> authorities =
                cliente.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol
                        .getRolNombre().name())).collect(Collectors.toList());
        return new ClientePrincipal(cliente.getNombre(), cliente.getEmail(), cliente.getNombreUsuario(), cliente.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

