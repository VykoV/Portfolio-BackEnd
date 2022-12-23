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
public class Proyectos {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    @Size(min=1,max=500,message="Ingrese correctamente los datos")
    private String nombreProyecto;
    @Size(min=1,max=500,message="Ingrese correctamente los datos")
    private String descripcionProyecto;
   
    private String urlRepositorio;
  
    private String urlImgProyecto;
    
    public Proyectos(){
    }
    
    public Proyectos(Long id,String nombreProyecto,String descripcionProyecto,String urlRepositorio,String urlImgProyecto){
    this.id=id;
    this.nombreProyecto=nombreProyecto;
    this.descripcionProyecto=descripcionProyecto;
    this.urlRepositorio=urlRepositorio;
    this.urlImgProyecto=urlImgProyecto;
    
    }

}
