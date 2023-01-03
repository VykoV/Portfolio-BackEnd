package com.argprog.portfolio.controller;

import com.argprog.portfolio.Interface.IAcercaDeMiService;
import com.argprog.portfolio.Security.Controller.Mensaje;
import com.argprog.portfolio.entity.AcercaDeMi;


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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("acercademi")
@CrossOrigin(origins="http://localhost:4200")
public class AcercaDeMiController {
    @Autowired private IAcercaDeMiService iAcercaDeMiService;
    
    @GetMapping ("/ver")
    @ResponseBody
    public List<AcercaDeMi> verAcercaDeMi(){
        return iAcercaDeMiService.verAcercaDeMi();
    }
    
    @PostMapping("/new")
    public void crearAcercaDeMi(@RequestBody AcercaDeMi adm){
        iAcercaDeMiService.crearAcercaDeMi(adm);
    }
    
    @DeleteMapping("/delete/{id}")
    public void borrarAcercaDeMi(@PathVariable Long id){
        iAcercaDeMiService.borrarAcercaDeMi(id);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody AcercaDeMi adm){
        //Validamos si existe el ID
        if(!iAcercaDeMiService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
       
        AcercaDeMi aDMi = iAcercaDeMiService.getOne(id).get();
        aDMi.setInformacionAcercaDeMi(adm.getInformacionAcercaDeMi());
        aDMi.setDestacable(adm.getDestacable());
        
        
        iAcercaDeMiService.crearAcercaDeMi(aDMi);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
             
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<AcercaDeMi> getById(@PathVariable("id") Long id){
        if(!iAcercaDeMiService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        AcercaDeMi experiencia = iAcercaDeMiService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    
}
