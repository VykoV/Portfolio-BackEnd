package com.argprog.portfolio.controller;

import com.argprog.portfolio.Interface.IProyectosService;
import com.argprog.portfolio.Security.Controller.Mensaje;
import com.argprog.portfolio.entity.Proyectos;
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
@RequestMapping("proyectos")
//@CrossOrigin(origins="http://localhost:4200")
@CrossOrigin(origins="https://portfoliovvalli.web.app")
public class ProyectosController {
    @Autowired
    private IProyectosService iProyectosService;
    
    @PostMapping("/nuevo")
    public void agregarProyectos (@RequestBody Proyectos proy){
        iProyectosService.crearProyectos(proy);
    }
    
    @GetMapping("/ver")
    @ResponseBody
    public List<Proyectos> verProyectos(){
       return iProyectosService.verProyectos();
    }
    
    @DeleteMapping ("/eliminar/{id}")
    public void borrarProyectos(@PathVariable Long id){
        iProyectosService.borrarProyectos(id);
    }
   
    @PutMapping("/actualizar/{id}")
    public void actualizar(@PathVariable("id") Long id, @RequestBody Proyectos proyec){

        Proyectos proy = iProyectosService.uno(id).get();
        proy.setNombreProyecto(proyec.getNombreProyecto());
        proy.setDescripcionProyecto(proyec.getDescripcionProyecto());
        proy.setUrlRepositorio(proyec.getUrlRepositorio());
        proy.setUrlImgProyecto(proyec.getUrlImgProyecto());
        
        iProyectosService.crearProyectos(proy);
    }
    
    @GetMapping("/proy/{id}")
    public Proyectos obtener(@PathVariable("id") Long id){
       
        Proyectos proy = iProyectosService.uno(id).get();
        return proy;
    }
    
}
