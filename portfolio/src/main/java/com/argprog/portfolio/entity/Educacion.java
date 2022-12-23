package com.argprog.portfolio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    @Size(min=1,max=500,message="Ingrese correctamente los datos")
    private String logo;
    
    @NotNull
    @Size(min=1,max=500,message="Ingrese correctamente los datos")
    private String nombreCurso;
    
    @NotNull
    @Size(min=1,max=500,message="Ingrese correctamente los datos")
    private String carreraCurso;
    
    @NotNull
    @Size(min=1,max=500,message="Ingrese correctamente los datos")
    private String titulo;
    
    @NotNull
    @Size(min=1,max=500,message="Ingrese correctamente los datos")
    private String periodoEstudiosInicio;
    
    @Size(min=1,max=500,message="Ingrese correctamente los datos")
    private String periodoEstudiosFin;
    
    public Educacion(){  
    }
    
    public Educacion(Long id, String logo, String nombreCurso, String carreraCurso, String titulo, String periodoEstudioInicio, String periodoEstudioFin){
        this.id=id;
        this.logo=logo;
        this.nombreCurso=nombreCurso;
        this.carreraCurso=carreraCurso;
        this.titulo=titulo;
        this.periodoEstudiosInicio=periodoEstudioInicio;
        this.periodoEstudiosFin=periodoEstudioFin;
        
    }
}
