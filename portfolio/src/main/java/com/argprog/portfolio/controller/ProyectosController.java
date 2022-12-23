package com.argprog.portfolio.controller;

import com.argprog.portfolio.Interface.IProyectosService;
import com.argprog.portfolio.entity.Proyectos;
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
@RequestMapping("proyectos")
@CrossOrigin(origins="http://localhost:4200")
public class ProyectosController {
    @Autowired
    private IProyectosService iProyectosService;
    
    @PostMapping("/new")
    public void agregarProyectos (@RequestBody Proyectos proy){
        iProyectosService.crearProyectos(proy);
    }
    
    @GetMapping("/ver")
    @ResponseBody
    public List<Proyectos> verProyectos(){
       return iProyectosService.verProyectos();
    }
    
    @DeleteMapping ("/delete/{id}")
    public void borrarProyectos(@PathVariable Long id){
        iProyectosService.borrarProyectos(id);
    }
    @PutMapping("editar/{id}")
    public Proyectos editarProyectos(@PathVariable Long id,
                                @RequestParam("nombreProyecto") String nuevonombreProyecto,
                                @RequestParam("descripcionProyecto") String nuevodescripcionProyecto,
                                @RequestParam("urlRepositorio") String nuevourlRepositorio,
                                @RequestParam("imgProyecto") String nuevourlImgProyecto){
        Proyectos proy =  iProyectosService.buscarProyectos(id);
        
        proy.setNombreProyecto(nuevonombreProyecto);
        proy.setDescripcionProyecto(nuevodescripcionProyecto);
        proy.setUrlRepositorio(nuevourlRepositorio);
        proy.setUrlImgProyecto(nuevourlImgProyecto);
        
        iProyectosService.crearProyectos(proy);
        return proy;
    }
}
