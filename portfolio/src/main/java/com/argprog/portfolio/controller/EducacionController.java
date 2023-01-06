package com.argprog.portfolio.controller;

import com.argprog.portfolio.Interface.IEducacionService;
import com.argprog.portfolio.entity.Educacion;

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
@RequestMapping("educacion")
@CrossOrigin(origins="http://localhost:4200")
public class EducacionController {
    
    @Autowired 
    private IEducacionService iEducacionService;
    
    @PostMapping("/nuevo")
    public void agregarEducacion(@RequestBody Educacion educa){
        iEducacionService.crearEducacion(educa);
    }
    
    @GetMapping ("/ver")
    @ResponseBody
    public List<Educacion>verEducacion(){
        return iEducacionService.verEducacion();
    }
 
    
    @DeleteMapping("/eliminar/{id}")
    public void borrarEducacion(@PathVariable Long id){
        iEducacionService.borrarEducacion(id);
    }
        
    @GetMapping("/ed/{id}")
    public Educacion obtener(@PathVariable("id") Long id){
        Educacion educ = iEducacionService.uno(id).get();
        return educ;
    }
    
     @PutMapping("/actualizar/{id}")
    public void actualizar(@PathVariable("id") Long id, @RequestBody Educacion educa){
        Educacion ed = iEducacionService.uno(id).get();
        ed.setLogo(educa.getLogo());
        ed.setNombreCurso(educa.getNombreCurso());
        ed.setCarreraCurso(educa.getCarreraCurso());
        ed.setTitulo(educa.getTitulo());
        ed.setPeriodoEstudiosInicio(educa.getPeriodoEstudiosInicio());
        ed.setPeriodoEstudiosFin(educa.getPeriodoEstudiosFin());
        iEducacionService.crearEducacion(ed);    
    }
    

    
}
