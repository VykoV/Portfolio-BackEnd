package com.argprog.portfolio.controller;

import com.argprog.portfolio.Interface.IHardSkillBackEndService;
import com.argprog.portfolio.entity.HardSkillBackEnd;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hardskillbackend")
//@CrossOrigin(origins="http://localhost:4200")
@CrossOrigin(origins="https://portfoliovvalli.web.app")
public class HardSkillBackEndController {
    @Autowired
    private IHardSkillBackEndService iHardSkillBackEndService;
    
    @PostMapping("/nuevo")
    public void agregarHardSkillBackEnd (@RequestBody HardSkillBackEnd hsbe){
        iHardSkillBackEndService.crearHardSkillBackEnd(hsbe);
    }
    
    @GetMapping("/ver")
    @ResponseBody
    public List<HardSkillBackEnd> verHardSkillBackEnd (){
       return iHardSkillBackEndService.verHardSkillBackEnd();
    }
    
    @DeleteMapping ("/eliminar/{id}")
    public void borrarHardSkillBackEnd(@PathVariable Long id){
        iHardSkillBackEndService.borrarHardSkillBackEnd(id);
    }
    
    @PutMapping("/actualizar/{id}")
    public void actualizar(@PathVariable("id") Long id, @RequestBody HardSkillBackEnd hsbe){
        HardSkillBackEnd hsbEnd = iHardSkillBackEndService.uno(id).get();
        hsbEnd.setIcono(hsbe.getIcono());
        hsbEnd.setNombreBackEnd(hsbe.getNombreBackEnd());
        hsbEnd.setNivelBackEnd(hsbe.getNivelBackEnd());
        hsbEnd.setPorcentaje(hsbe.getPorcentaje());
        
        iHardSkillBackEndService.crearHardSkillBackEnd(hsbEnd);     
    }
    
    @GetMapping("/hsbe/{id}")
    public HardSkillBackEnd obtener(@PathVariable("id") Long id){
        HardSkillBackEnd hsbe = iHardSkillBackEndService.uno(id).get();
        return hsbe;
    }
}

