package com.argprog.portfolio.controller;

import com.argprog.portfolio.Interface.ISoftSkillService;
import com.argprog.portfolio.Security.Controller.Mensaje;
import com.argprog.portfolio.entity.SoftSkill;

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
@RequestMapping("softskill")
@CrossOrigin(origins="http://localhost:4200")
public class SoftSkillController {
    @Autowired
    private ISoftSkillService iSoftSkillService;
    
    @PostMapping("/new")
    public void agregarSoftSkill (@RequestBody SoftSkill ss){
        iSoftSkillService.crearSoftSkill(ss);
    }
    
    @GetMapping("/ver")
    @ResponseBody
    public List<SoftSkill> verSoftSkill(){
       return iSoftSkillService.verSoftSkill();
    }
    
    @DeleteMapping ("/delete/{id}")
    public void borrarSoftSkill(@PathVariable Long id){
        iSoftSkillService.borrarSoftSkill(id);
    }
    
    
     @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody SoftSkill ss){
        //Validamos si existe el ID
        if(!iSoftSkillService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
       
        SoftSkill sskill = iSoftSkillService.getOne(id).get();
        sskill.setIcono(ss.getIcono());
        sskill.setNombreSkill(ss.getNombreSkill());
        sskill.setNivelSkill(ss.getNivelSkill());
        sskill.setPorcentaje(ss.getPorcentaje());
        
        iSoftSkillService.crearSoftSkill(sskill);
        return new ResponseEntity(new Mensaje("Soft Skill actualizada"), HttpStatus.OK);
             
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<SoftSkill> getById(@PathVariable("id") Long id){
        if(!iSoftSkillService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        SoftSkill ss = iSoftSkillService.getOne(id).get();
        return new ResponseEntity(ss, HttpStatus.OK);
    }
    
    
}
