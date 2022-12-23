package com.argprog.portfolio.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min=1,max=500,message="Ingrese correctamente los datos")
    private String usuario;
    @NotNull
    @Size(min=1,max=500,message="Ingrese correctamente los datos")
    private Long contraseña;
}
