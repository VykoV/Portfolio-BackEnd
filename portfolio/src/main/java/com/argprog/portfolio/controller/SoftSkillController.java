package com.argprog.portfolio.controller;

import com.argprog.portfolio.Interface.ISoftSkillService;
import com.argprog.portfolio.entity.SoftSkill;

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
@RequestMapping("softskill")
@CrossOrigin(origins="http://localhost:4200")
public class SoftSkillController {
    @Autowired
    private ISoftSkillService iSoftSkillService;
    
    @PostMapping("/new")
    public void agregarSoftSkill (@RequestBody SoftSkill ss){
        iSoftSkillService.crearSoftSkill(ss);
    }
    
    @GetMapping("/ver")
    @ResponseBody
    public List<SoftSkill> verSoftSkill(){
       return iSoftSkillService.verSoftSkill();
    }
    
    @DeleteMapping ("/delete/{id}")
    public void borrarSoftSkill(@PathVariable Long id){
        iSoftSkillService.borrarSoftSkill(id);
    }
    
    @PutMapping("editar/{id}")
    public SoftSkill editarSoftSkill(@PathVariable Long id,
                                @RequestParam("icono") String nuevoicono,
                                @RequestParam("nombreSkill") String nuevonombreSkill,
                                @RequestParam("nivelSkill") String nuevonivelSkill,
                                @RequestParam("porcentaje") int nuevoporcentaje){
        SoftSkill ss =  iSoftSkillService.buscarSoftSkill(id);
        
        ss.setIcono(nuevoicono);
        ss.setNombreSkill(nuevonombreSkill);
        ss.setNivelSkill(nuevonivelSkill);
        ss.setPorcentaje(nuevoporcentaje);
        

        iSoftSkillService.crearSoftSkill(ss);
        return ss;
    }
}
