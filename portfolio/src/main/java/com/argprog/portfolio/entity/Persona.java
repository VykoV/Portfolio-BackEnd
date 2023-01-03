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
public class Persona {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Size(min=1,max=500)
    private String imgBanner;
    
    @NotNull
    @Size(min=1,max=500)
    private String imgPerfil;
    
    @NotNull
    @Size(min=1,max=500)
    private String nombrePerfil;
    
    @NotNull
    @Size(min=1,max=500)
    private String titulo;
    
    public Persona(){    
    }
    
    
    public Persona(Long id,String imgBanner,String imgPerfil, String nombrePerfil, String titulo){
        this.id=id;
        this.imgBanner= imgBanner;
        this.imgPerfil= imgPerfil;
        this.nombrePerfil= nombrePerfil;
        this.titulo=titulo;
        
                
    }
}
