package com.argprog.portfolio.controller;

import com.argprog.portfolio.Interface.IHardSkillBackEndService;
import com.argprog.portfolio.Security.Controller.Mensaje;
import com.argprog.portfolio.entity.HardSkillBackEnd;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody HardSkillBackEnd hsbe){
        if(!iHardSkillBackEndService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);

        HardSkillBackEnd hsbEnd = iHardSkillBackEndService.getOne(id).get();
        hsbEnd.setIcono(hsbe.getIcono());
        hsbEnd.setNombreBackEnd(hsbe.getNombreBackEnd());
        hsbEnd.setNivelBackEnd(hsbe.getNivelBackEnd());
        hsbEnd.setPorcentaje(hsbe.getPorcentaje());
        
        iHardSkillBackEndService.crearHardSkillBackEnd(hsbEnd);
        return new ResponseEntity(new Mensaje("Hard Skill Back End actualizada"), HttpStatus.OK);
             
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<HardSkillBackEnd> getById(@PathVariable("id") Long id){
        if(!iHardSkillBackEndService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        HardSkillBackEnd hsbe = iHardSkillBackEndService.getOne(id).get();
        return new ResponseEntity(hsbe, HttpStatus.OK);
    }
}

