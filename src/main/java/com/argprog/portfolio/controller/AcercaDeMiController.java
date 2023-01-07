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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("acercademi")
//@CrossOrigin(origins="http://localhost:4200")
@CrossOrigin(origins="https://portfoliovvalli.web.app")
public class AcercaDeMiController {
    @Autowired private IAcercaDeMiService iAcercaDeMiService;
    
    @GetMapping ("/ver")
    @ResponseBody
    public List<AcercaDeMi> verAcercaDeMi(){
        return iAcercaDeMiService.verAcercaDeMi();
    }
    
    @PostMapping("/nuevo")
    public void crearAcercaDeMi(@RequestBody AcercaDeMi adm){
        iAcercaDeMiService.crearAcercaDeMi(adm);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public void borrarAcercaDeMi(@PathVariable Long id){
        iAcercaDeMiService.borrarAcercaDeMi(id);
    }
    
    @GetMapping("/adm/{id}")
    public AcercaDeMi obtener(@PathVariable("id") Long id){
        AcercaDeMi experiencia = iAcercaDeMiService.uno(id).get();
        return experiencia;
    }
    

    @PutMapping("/actualizar/{id}")
    public void actualizar(@PathVariable("id") Long id, @RequestBody AcercaDeMi adm){
        AcercaDeMi aDMi = iAcercaDeMiService.uno(id).get();
        aDMi.setInformacionAcercaDeMi(adm.getInformacionAcercaDeMi());
        aDMi.setDestacable(adm.getDestacable());
        iAcercaDeMiService.crearAcercaDeMi(aDMi);
        
    }
    
}
