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
public class HardSkillFrontEnd {
  
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String icono;
    @NotNull
    @Size(min=1,max=500)
    private String nombreFrontEnd;
    @NotNull
    @Size(min=1,max=500)
    private String nivelFrontEnd;
    @NotNull
    @Min(0)
    @Max(100)
    private int porcentaje;

    public HardSkillFrontEnd(){
    
    }
    
    public HardSkillFrontEnd(Long id,String icono,String nombreFrontEnd,String nivelFrontEnd,int porcentaje){
        this.id=id;
        this.icono=icono;
        this.nombreFrontEnd=nombreFrontEnd;
        this.nivelFrontEnd=nivelFrontEnd;
        this.porcentaje=porcentaje;
        
    }
}
