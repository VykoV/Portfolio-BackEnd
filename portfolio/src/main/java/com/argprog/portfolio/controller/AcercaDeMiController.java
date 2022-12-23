package com.argprog.portfolio.controller;

import com.argprog.portfolio.Interface.IAcercaDeMiService;
import com.argprog.portfolio.entity.AcercaDeMi;


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
    
    @PutMapping("editar/{id}")
    public AcercaDeMi editarAcercaDeMi(@PathVariable Long id,
                                @RequestParam("informacionAcercaDeMi") String nuevoinformacionAcercaDeMi,
                                @RequestParam("destacable") String nuevodestacable){
        AcercaDeMi adm =  iAcercaDeMiService.buscarAcercaDeMi(id);
        
        adm.setInformacionAcercaDeMi(nuevoinformacionAcercaDeMi);
        adm.setDestacable(nuevodestacable);
        
        
        iAcercaDeMiService.crearAcercaDeMi(adm);
        return adm;
    }
}
