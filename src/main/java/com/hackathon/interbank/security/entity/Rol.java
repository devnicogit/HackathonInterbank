package com.hackathon.interbank.security.entity;

import com.fasterxml.jackson.annotation.*;
import com.hackathon.interbank.security.enums.RolNombre;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIgnoreProperties("clientes")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rol_id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;

    @ManyToMany(mappedBy = "roles")
    @JsonManagedReference
    private Set<Usuario> clientes = new HashSet<>();

    public Rol() {
    }

    public Rol(Long rol_id){
        this.rol_id = rol_id;
    }

    public Rol(@NotNull RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }

    public Long getId() {
        return rol_id;
    }

    public void setId(Long rol_id) {
        this.rol_id = rol_id;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}
