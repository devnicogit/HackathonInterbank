package com.hackathon.interbank.security.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nombre;

    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @NotNull
    @Column(unique = true)
    private String nombreUsuario;
    @NotNull
    private String password;
    private String tokenPassword;
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "cliente_rol", joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    //@JsonManagedReference
    @JsonBackReference
    private Set<Rol> roles = new HashSet<>();



    public Cliente() {
    }

    public Cliente(Long id){
        this.id= id;
    }

    public static Cliente fromId(Long id) {
        return new Cliente(id);
    }


    public Cliente(@NotNull String nombre, @NotNull String email, @NotNull String nombreUsuario, @NotNull String password) {
        this.nombre = nombre;
        this.email = email;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
