package com.argprog.portfolio.controller;

import com.argprog.portfolio.Interface.IHardSkillFrontEndService;
import com.argprog.portfolio.entity.HardSkillFrontEnd;

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
@RequestMapping("hardskillfrontend")
@CrossOrigin(origins="http://localhost:4200")
public class HardSkillFrontEndController {
    @Autowired
    private IHardSkillFrontEndService iHardSkillFrontEndService;
    
    @PostMapping("/new")
    public void agregarHardSkillFrontEnd (@RequestBody HardSkillFrontEnd hsfe){
        iHardSkillFrontEndService.crearHardSkillFrontEnd(hsfe);
    }
    
    @GetMapping("/ver")
    @ResponseBody
    public List<HardSkillFrontEnd> verHardSkillFrontEnd (){
       return iHardSkillFrontEndService.verHardSkillFrontEnd();
    }
    
    @DeleteMapping ("/delete/{id}")
    public void borrarHardSkillFrontEnd(@PathVariable Long id){
       iHardSkillFrontEndService.borrarHardSkillFrontEnd(id);
    }
    
    @PutMapping("editar/{id}")
    public HardSkillFrontEnd editarHardSkillFrontEnd(@PathVariable Long id,
                                @RequestParam("icono") String nuevoicono,
                                @RequestParam("nombreFrontEnd") String nuevonombreFrontEnd,
                                @RequestParam("nivelFrontEnd") String nuevonivelFrontEnd,
                                @RequestParam("porcentaje") int nuevoporcentaje){
        HardSkillFrontEnd hsfe =  iHardSkillFrontEndService.buscarHardSkillFrontEnd(id);
        
        hsfe.setIcono(nuevoicono);
        hsfe.setNombreFrontEnd(nuevonombreFrontEnd);
        hsfe.setNivelFrontEnd(nuevonivelFrontEnd);
        hsfe.setPorcentaje(nuevoporcentaje);
        

        iHardSkillFrontEndService.crearHardSkillFrontEnd(hsfe);
        return hsfe;
    }
}
