package com.argprog.portfolio.controller;

import com.argprog.portfolio.Interface.IHardSkillFrontEndService;
import com.argprog.portfolio.Security.Controller.Mensaje;
import com.argprog.portfolio.entity.HardSkillFrontEnd;

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
@RequestMapping("hardskillfrontend")
@CrossOrigin(origins="http://localhost:4200")
public class HardSkillFrontEndController {
    @Autowired
    private IHardSkillFrontEndService iHardSkillFrontEndService;
    
    @PostMapping("/new")
    public void agregarHardSkillFrontEnd (@RequestBody HardSkillFrontEnd hsfe){
        iHardSkillFrontEndService.crearHardSkillFrontEnd(hsfe);
    }
    
    @GetMapping("/ver")
    @ResponseBody
    public List<HardSkillFrontEnd> verHardSkillFrontEnd (){
       return iHardSkillFrontEndService.verHardSkillFrontEnd();
    }
    
    @DeleteMapping ("/delete/{id}")
    public void borrarHardSkillFrontEnd(@PathVariable Long id){
       iHardSkillFrontEndService.borrarHardSkillFrontEnd(id);
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody HardSkillFrontEnd hsfe){
        if(!iHardSkillFrontEndService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        HardSkillFrontEnd hsfEnd = iHardSkillFrontEndService.getOne(id).get();
        hsfEnd.setIcono(hsfe.getIcono());
        hsfEnd.setNombreFrontEnd(hsfe.getNombreFrontEnd());
        hsfEnd.setNivelFrontEnd(hsfe.getNivelFrontEnd());
        hsfEnd.setPorcentaje(hsfe.getPorcentaje());
        
        iHardSkillFrontEndService.crearHardSkillFrontEnd(hsfEnd);
        return new ResponseEntity(new Mensaje("Hard Skill Front End actualizada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<HardSkillFrontEnd> getById(@PathVariable("id") Long id){
        if(!iHardSkillFrontEndService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        HardSkillFrontEnd hsfe = iHardSkillFrontEndService.getOne(id).get();
        return new ResponseEntity(hsfe, HttpStatus.OK);
    }
    
}
