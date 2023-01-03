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
@CrossOrigin(origins="http://localhost:4200")
public class ProyectosController {
    @Autowired
    private IProyectosService iProyectosService;
    
    @PostMapping("/new")
    public void agregarProyectos (@RequestBody Proyectos proy){
        iProyectosService.crearProyectos(proy);
    }
    
    @GetMapping("/ver")
    @ResponseBody
    public List<Proyectos> verProyectos(){
       return iProyectosService.verProyectos();
    }
    
    @DeleteMapping ("/delete/{id}")
    public void borrarProyectos(@PathVariable Long id){
        iProyectosService.borrarProyectos(id);
    }
   
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Proyectos proyec){
        //Validamos si existe el ID
        if(!iProyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
       
        Proyectos proy = iProyectosService.getOne(id).get();
        proy.setNombreProyecto(proyec.getNombreProyecto());
        proy.setDescripcionProyecto(proyec.getDescripcionProyecto());
        proy.setUrlRepositorio(proyec.getUrlRepositorio());
        proy.setUrlImgProyecto(proyec.getUrlImgProyecto());
        
        iProyectosService.crearProyectos(proy);
        return new ResponseEntity(new Mensaje("Hard Skill Back End actualizada"), HttpStatus.OK);
             
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") Long id){
        if(!iProyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyectos hsbe = iProyectosService.getOne(id).get();
        return new ResponseEntity(hsbe, HttpStatus.OK);
    }
    
}
