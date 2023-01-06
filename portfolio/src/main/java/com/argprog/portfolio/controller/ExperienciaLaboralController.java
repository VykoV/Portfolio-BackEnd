package com.argprog.portfolio.controller;

import com.argprog.portfolio.Interface.IExperienciaLaboralService;
import com.argprog.portfolio.Security.Controller.Mensaje;

import com.argprog.portfolio.entity.ExperienciaLaboral;
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
@RequestMapping("experiencialaboral")
@CrossOrigin(origins="http://localhost:4200")
public class ExperienciaLaboralController {
    @Autowired IExperienciaLaboralService iExperienciaLaboralService;
    
    @PostMapping("/new")
    public void agregarExperienciaLaboral (@RequestBody ExperienciaLaboral el){
        iExperienciaLaboralService.crearExperienciaLaboral(el);
    }
    
    @GetMapping("/ver")
    @ResponseBody
    public List<ExperienciaLaboral> verExperienciaLaboral (){
       return iExperienciaLaboralService.verExperienciaLaboral();
    }
    
    @DeleteMapping ("/delete/{id}")
    public void borrarExperienciaLaboral(@PathVariable Long id){
        iExperienciaLaboralService.borrarExperienciaLaboral(id);
    }
    
    /*@PutMapping("update/{id}")
    public ExperienciaLaboral editarExperienciaLaboral(@PathVariable Long id,
                                @RequestParam("imgEmpresa") String nuevoimgEmpresa,
                                @RequestParam("nombreEmpresa") String nuevonombreEmpresa,
                                @RequestParam("puesto") String nuevopuesto,
                                @RequestParam("periodoPuestoInicio") String nuevoperiodoPuestoInicio,
                                @RequestParam("periodoPuestoFin") String nuevoperiodoPuestoFin,
                                @RequestParam("descripcion") String nuevodescripcion){
        ExperienciaLaboral el =  iExperienciaLaboralService.buscarExperienciaLaboral(id);
        
        el.setImgEmpresa(nuevoimgEmpresa);
        el.setNombreEmpresa(nuevonombreEmpresa);
        el.setPuesto(nuevopuesto);
        el.setPeriodoPuestoInicio(nuevoperiodoPuestoInicio);
        el.setPeriodoPuestoFin(nuevoperiodoPuestoFin);
        el.setDescripcion(nuevodescripcion);
        
        
        iExperienciaLaboralService.crearExperienciaLaboral(el);
        return el;
    }*/
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ExperienciaLaboral el){

        if(!iExperienciaLaboralService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);

       
        ExperienciaLaboral experiencia = iExperienciaLaboralService.getOne(id).get();
        experiencia.setNombreEmpresa(el.getNombreEmpresa());
        experiencia.setImgEmpresa(el.getImgEmpresa());
        experiencia.setPuesto(el.getPuesto());
        experiencia.setPeriodoPuestoInicio(el.getPeriodoPuestoInicio());
        experiencia.setPeriodoPuestoFin(el.getPeriodoPuestoFin());
        experiencia.setDescripcion(el.getDescripcion());
        
        
        iExperienciaLaboralService.crearExperienciaLaboral(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia laboral actualizada"), HttpStatus.OK);
             
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<ExperienciaLaboral> getById(@PathVariable("id") Long id){
        if(!iExperienciaLaboralService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ExperienciaLaboral experiencia = iExperienciaLaboralService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
}
