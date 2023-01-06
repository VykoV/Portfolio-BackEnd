package com.argprog.portfolio.controller;

import com.argprog.portfolio.Interface.IEducacionService;
import com.argprog.portfolio.Security.Controller.Mensaje;
import com.argprog.portfolio.entity.Educacion;

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
@RequestMapping("educacion")
@CrossOrigin(origins="http://localhost:4200")
public class EducacionController {
    
    @Autowired 
    private IEducacionService iEducacionService;
    
    @PostMapping("/new")
    public void agregarEducacion(@RequestBody Educacion educa){
        iEducacionService.crearEducacion(educa);
    }
    
    @GetMapping ("/ver")
    @ResponseBody
    public List<Educacion>verEducacion(){
        return iEducacionService.verEducacion();
    }
  
    
    @DeleteMapping("/delete/{id}")
    public void borrarEducacion(@PathVariable Long id){
        iEducacionService.borrarEducacion(id);
    }
        
    
    
     @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Educacion educa){
        if(!iEducacionService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        Educacion ed = iEducacionService.getOne(id).get();
        ed.setLogo(educa.getLogo());
        ed.setNombreCurso(educa.getNombreCurso());
        ed.setCarreraCurso(educa.getCarreraCurso());
        ed.setTitulo(educa.getTitulo());
        ed.setPeriodoEstudiosInicio(educa.getPeriodoEstudiosInicio());
        ed.setPeriodoEstudiosFin(educa.getPeriodoEstudiosFin());
        
        
        iEducacionService.crearEducacion(ed);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
             
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") Long id){
        if(!iEducacionService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion experiencia = iEducacionService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
}
