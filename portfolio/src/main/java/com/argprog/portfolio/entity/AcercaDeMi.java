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
public class AcercaDeMi {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
   
    @NotNull
    @Size(min=1,max=500,message="Ingrese correctamente los datos")
    private String destacable;
   
    @NotNull
    @Size(min=1,max=500,message="Ingrese correctamente los datos")
    private String informacionAcercaDeMi;
    
    public AcercaDeMi(){
    }

    public AcercaDeMi(Long id,String destacable,String informacionAcercaDeMi){
        this.id= id;
        this.destacable=destacable;
        this.informacionAcercaDeMi=informacionAcercaDeMi;
    }

}
