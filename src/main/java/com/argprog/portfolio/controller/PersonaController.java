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
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")
//@CrossOrigin(origins="http://localhost:4200")
@CrossOrigin(origins="https://portfoliovvalli.web.app")
public class PersonaController {
    
    @Autowired
    private IPersonaService persoServ;
    
    /*
    @PostMapping("/nuevo")
    @PreAuthorize("hasRole('ADMIN')")
    public void agregarPersona (@RequestBody Persona pers){
        persoServ.crearPersona(pers);
    }
    */
    
    @GetMapping("/ver")
    @ResponseBody
    public List<Persona> verPersonas (){
       return persoServ.verPersonas();
    }
    
    
    /*@DeleteMapping ("/eliminar/{id}")
    public void borrarPersona(@PathVariable Long id){
        persoServ.borrarPersona(id);
    }*/
    
    
    @PutMapping("/actualizar/{id}")
    public void actualizar(@PathVariable("id") Long id, @RequestBody Persona perso){
        Persona Per = persoServ.uno(id).get();
        Per.setNombrePerfil(perso.getNombrePerfil());
        Per.setImgBanner(perso.getImgBanner());
        Per.setImgPerfil(perso.getImgPerfil());
        Per.setTitulo(perso.getTitulo());

        persoServ.crearPersona(Per);
    }
    
    @GetMapping("/pers/{id}")
    public Persona obtener(@PathVariable("id") Long id){
       
        Persona experiencia = persoServ.uno(id).get();
        return experiencia;
    }
}
