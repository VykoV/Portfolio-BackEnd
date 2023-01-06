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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hardskillfrontend")
@CrossOrigin(origins = "http://localhost:4200")
public class HardSkillFrontEndController {

    @Autowired
    private IHardSkillFrontEndService iHardSkillFrontEndService;

    @PostMapping("/nuevo")
    public void agregarHardSkillFrontEnd(@RequestBody HardSkillFrontEnd hsfe) {
        iHardSkillFrontEndService.crearHardSkillFrontEnd(hsfe);
    }

    @GetMapping("/ver")
    @ResponseBody
    public List<HardSkillFrontEnd> verHardSkillFrontEnd() {
        return iHardSkillFrontEndService.verHardSkillFrontEnd();
    }

    @DeleteMapping("/eliminar/{id}")
    public void borrarHardSkillFrontEnd(@PathVariable Long id) {
        iHardSkillFrontEndService.borrarHardSkillFrontEnd(id);
    }

    @PutMapping("/actualizar/{id}")
    public void actualizar(@PathVariable("id") Long id, @RequestBody HardSkillFrontEnd hsfe) {
        HardSkillFrontEnd hsfEnd = iHardSkillFrontEndService.uno(id).get();
        hsfEnd.setIcono(hsfe.getIcono());
        hsfEnd.setNombreFrontEnd(hsfe.getNombreFrontEnd());
        hsfEnd.setNivelFrontEnd(hsfe.getNivelFrontEnd());
        hsfEnd.setPorcentaje(hsfe.getPorcentaje());

        iHardSkillFrontEndService.crearHardSkillFrontEnd(hsfEnd);

    }

    @GetMapping("/hsfe/{id}")
    public HardSkillFrontEnd obtener(@PathVariable("id") Long id) {
        HardSkillFrontEnd hsfe = iHardSkillFrontEndService.uno(id).get();
        return hsfe;
    }

}
