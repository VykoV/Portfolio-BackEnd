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
import org.springframework.web.bind.annotation.RequestParam;
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
        
    @PutMapping("editar/{id}")
    public Educacion editarEducacion(@PathVariable Long id,
                                @RequestParam("logo") String nuevologo,
                                @RequestParam("nombreCurso") String nuevonombreCurso,
                                @RequestParam("carreraCurso") String nuevocarreraCurso,
                                @RequestParam("titulo") String nuevotitulo,
                                @RequestParam("periodoEstudiosInicio") String nuevoperiodoEstudiosInicio,
                                @RequestParam("periodoEstudiosFin") String nuevoperiodoEstudiosFin){
        Educacion educa =  iEducacionService.buscarEducacion(id);
        
        educa.setLogo(nuevologo);
        educa.setNombreCurso(nuevonombreCurso);
        educa.setCarreraCurso(nuevocarreraCurso);
        educa.setTitulo(nuevotitulo);
        educa.setPeriodoEstudiosInicio(nuevoperiodoEstudiosInicio);
        educa.setPeriodoEstudiosFin(nuevoperiodoEstudiosFin);
      
        
        iEducacionService.crearEducacion(educa);
        return educa;
    }
    
}
