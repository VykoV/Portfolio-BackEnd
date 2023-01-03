package com.argprog.portfolio.controller;

import com.argprog.portfolio.entity.Persona;
import com.argprog.portfolio.Interface.IPersonaService;
import com.argprog.portfolio.Security.Controller.Mensaje;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/*import org.springframework.security.access.prepost.PreAuthorize;*/
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
@RequestMapping("persona")
@CrossOrigin(origins="http://localhost:4200")
public class PersonaController {
    
    @Autowired
    private IPersonaService persoServ;
    
    
    @PostMapping("/new")
    /*@PreAuthorize("hasRole('ADMIN')")*/
    public void agregarPersona (@RequestBody Persona pers){
        persoServ.crearPersona(pers);
    }
    
    @GetMapping("/ver")
    @ResponseBody
    public List<Persona> verPersonas (){
       return persoServ.verPersonas();
    }
    
    
    @DeleteMapping ("/delete/{id}")
    public void borrarPersona(@PathVariable Long id){
        persoServ.borrarPersona(id);
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Persona perso){
        //Validamos si existe el ID
        if(!persoServ.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
       
        Persona Per = persoServ.getOne(id).get();
        Per.setNombrePerfil(perso.getNombrePerfil());
        Per.setImgBanner(perso.getImgBanner());
        Per.setImgPerfil(perso.getImgPerfil());
        Per.setTitulo(perso.getTitulo());
        
        
        persoServ.crearPersona(Per);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
             
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") Long id){
        if(!persoServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona experiencia = persoServ.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
}
