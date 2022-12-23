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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hardskillbackend")
@CrossOrigin(origins="http://localhost:4200")
public class HardSkillBackEndController {
    
    @Autowired
    private IHardSkillBackEndService iHardSkillBackEndService;
    
    @PostMapping("/new")
    public void agregarHardSkillBackEnd (@RequestBody HardSkillBackEnd hsbe){
        iHardSkillBackEndService.crearHardSkillBackEnd(hsbe);
    }
    
    @GetMapping("/ver")
    @ResponseBody
    public List<HardSkillBackEnd> verHardSkillBackEnd (){
       return iHardSkillBackEndService.verHardSkillBackEnd();
    }
    
    @DeleteMapping ("/delete/{id}")
    public void borrarHardSkillBackEnd(@PathVariable Long id){
        iHardSkillBackEndService.borrarHardSkillBackEnd(id);
    }
    
    @PutMapping("editar/{id}")
    public HardSkillBackEnd editarHardSkillBackEnd(@PathVariable Long id,
                                @RequestParam("icono") String nuevoicono,
                                @RequestParam("nombreBackEnd") String nuevonombreBackEnd,
                                @RequestParam("nivelBackEnd") String nuevonivelBackEnd,
                                @RequestParam("porcentaje") int nuevoporcentaje){
        HardSkillBackEnd hsbe =  iHardSkillBackEndService.buscarHardSkillBackEnd(id);
        
        hsbe.setIcono(nuevoicono);
        hsbe.setNombreBackEnd(nuevonombreBackEnd);
        hsbe.setNivelBackEnd(nuevonivelBackEnd);
        hsbe.setPorcentaje(nuevoporcentaje);
        

        iHardSkillBackEndService.crearHardSkillBackEnd(hsbe);
        return hsbe;
    }
}
