package com.argprog.portfolio.controller;

import com.argprog.portfolio.entity.Persona;
import com.argprog.portfolio.Interface.IPersonaService;

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
@RequestMapping("persona")
@CrossOrigin(origins="http://localhost:4200")
public class PersonaController {
    
    @Autowired
    private IPersonaService persoServ;
    
    @PostMapping("/new")
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
    
    @PutMapping("editar/{id}")
    public Persona editarPersona(@PathVariable Long id,
                                @RequestParam("nombrePerfil") String nuevonombrePerfil,
                                @RequestParam("imgBanner") String nuevoimgBanner,
                                @RequestParam("imgPerfil") String nuevoimgPerfil,
                                @RequestParam("titulo") String nuevotitulo){
        Persona persona =  persoServ.buscarPersona(id);
        
        persona.setImgBanner(nuevoimgBanner);
        persona.setImgPerfil(nuevoimgPerfil);
        persona.setNombrePerfil(nuevonombrePerfil);
        persona.setTitulo(nuevotitulo);
        
        persoServ.crearPersona(persona);
        return persona;
    }
}
