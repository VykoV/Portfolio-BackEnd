package com.argprog.portfolio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class SoftSkill {
   @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull
    private String icono;
    
    @NotNull
    @Size(min=1,max=500,message="Ingrese correctamente los datos")
    private String nombreSkill;
    
    @NotNull
    @Size(min=1,max=500,message="Ingrese correctamente los datos")
    private String nivelSkill;
    
    @NotNull
    @Min(0)
    @Max(100)
    private int porcentaje;

    public SoftSkill(){
    
    }
    
    public SoftSkill(Long id,String icono,String nombreSkill,String nivelSkill,int porcentaje){
        this.id=id;
        this.icono=icono;
        this.nombreSkill=nombreSkill;
        this.nivelSkill=nivelSkill;
        this.porcentaje=porcentaje;
        
    }
}
