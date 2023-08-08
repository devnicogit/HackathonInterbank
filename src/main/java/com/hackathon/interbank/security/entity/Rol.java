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
    private Long id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;

    @ManyToMany(mappedBy = "roles")
    @JsonManagedReference
    private Set<Cliente> clientes = new HashSet<>();

    public Rol() {
    }

    public Rol(Long id){
        this.id = id;
    }

    public Rol(@NotNull RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}
