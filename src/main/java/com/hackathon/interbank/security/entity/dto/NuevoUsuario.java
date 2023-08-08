package com.hackathon.interbank.security.entity.dto;

import com.hackathon.interbank.security.entity.Rol;
import com.hackathon.interbank.security.enums.RolNombre;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

public class NuevoUsuario {
    @NotBlank
    private String nombre;

    @NotBlank
    private String nombreUsuario;
    @Email
    private String email;
    @NotBlank
    private String password;

    private Set<RolDto> roles1 = new HashSet<>();
    private Set<Rol> roles = new HashSet<>();

    private Set<RolNombre> roles2 = new HashSet<>();

    private Set<Long> rolIds;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public Set<Long> getRolIds() {
        return rolIds;
    }

    public void setRolIds(Set<Long> rolIds) {
        this.rolIds = rolIds;
    }

    public Set<RolDto> getRoles1() {
        return roles1;
    }

    public void setRoles1(Set<RolDto> roles1) {
        this.roles1 = roles1;
    }

    public Set<RolNombre> getRoles2() {
        return roles2;
    }

    public void setRoles2(Set<RolNombre> roles2) {
        this.roles2 = roles2;
    }
}
