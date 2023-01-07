package com.argprog.portfolio.controller;

import com.argprog.portfolio.Interface.IExperienciaLaboralService;

import com.argprog.portfolio.entity.ExperienciaLaboral;
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
@RequestMapping("experiencialaboral")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaLaboralController {

    @Autowired
    IExperienciaLaboralService iExperienciaLaboralService;

    @PostMapping("/nuevo")
    public void agregarExperienciaLaboral(@RequestBody ExperienciaLaboral el) {
        iExperienciaLaboralService.crearExperienciaLaboral(el);
    }

    @GetMapping("/ver")
    @ResponseBody
    public List<ExperienciaLaboral> verExperienciaLaboral() {
        return iExperienciaLaboralService.verExperienciaLaboral();
    }

    @DeleteMapping("/eliminar/{id}")
    public void borrarExperienciaLaboral(@PathVariable Long id) {
        iExperienciaLaboralService.borrarExperienciaLaboral(id);
    }

    @PutMapping("/actualizar/{id}")
    public void actualizar(@PathVariable("id") Long id, @RequestBody ExperienciaLaboral el) {
        ExperienciaLaboral experiencia = iExperienciaLaboralService.uno(id).get();
        experiencia.setNombreEmpresa(el.getNombreEmpresa());
        experiencia.setImgEmpresa(el.getImgEmpresa());
        experiencia.setPuesto(el.getPuesto());
        experiencia.setPeriodoPuestoInicio(el.getPeriodoPuestoInicio());
        experiencia.setPeriodoPuestoFin(el.getPeriodoPuestoFin());
        experiencia.setDescripcion(el.getDescripcion());

        iExperienciaLaboralService.crearExperienciaLaboral(experiencia);

    }

    @GetMapping("/el/{id}")
    public ExperienciaLaboral obtener(@PathVariable("id") Long id) {
        ExperienciaLaboral experiencia = iExperienciaLaboralService.uno(id).get();
        return experiencia;
    }

}
