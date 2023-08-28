package com.hackathon.interbank.security.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuario_id;
    @NotNull
    private String nombre;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @NotNull
    private String password;
    private String tokenPassword;
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    //@JsonManagedReference
    @JsonBackReference
    private Set<Rol> roles = new HashSet<>();



    public Usuario() {
    }

    public Usuario(Long usuario_id){
        this.usuario_id= usuario_id;
    }

    public static Usuario fromId(Long usuario_id) {
        return new Usuario(usuario_id);
    }


    public Usuario(@NotNull String nombre, @NotNull String email, @NotNull String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return usuario_id;
    }

    public void setId(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getTokenPassword() {
        return tokenPassword;
    }

    public void setTokenPassword(String tokenPassword) {
        this.tokenPassword = tokenPassword;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

}
