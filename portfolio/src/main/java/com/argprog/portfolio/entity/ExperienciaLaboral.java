package com.argprog.portfolio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class ExperienciaLaboral {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    private String imgEmpresa;

    @Size(min=1,max=500)
    private String nombreEmpresa;

    @Size(min=1,max=500)
    private String puesto;
    
    @Size(min=1,max=500)
    private String periodoPuestoInicio;

    @Size(min=1,max=500)
    private String periodoPuestoFin;

    @Size(min=1,max=500)
    private String descripcion;
    
    public ExperienciaLaboral(){  
    }
    
    public ExperienciaLaboral(Long id, String imgEmpresa, String nombreEmpresa, String puesto, String periodoPuestoInicio, String periodoPuestoFin, String descripcion){
        this.id=id;
        this.imgEmpresa=imgEmpresa;
        this.nombreEmpresa=nombreEmpresa;
        this.puesto=puesto;
        this.periodoPuestoInicio=periodoPuestoInicio;
        this.periodoPuestoFin=periodoPuestoFin;
        this.descripcion=descripcion;
    }
    
    
}
