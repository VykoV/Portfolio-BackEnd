package com.argprog.portfolio.service;

import com.argprog.portfolio.Interface.IProyectosService;
import com.argprog.portfolio.entity.Proyectos;
import com.argprog.portfolio.repository.ProyectosRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectosService implements IProyectosService{
    
    @Autowired
    public ProyectosRepository proyectosRepository;
    
    @Override
    public List<Proyectos> verProyectos() {
        return proyectosRepository.findAll();
    }

    @Override
    public void crearProyectos(Proyectos proy) {
        proyectosRepository.save(proy);
    }

    @Override
    public void borrarProyectos(Long id) {
        proyectosRepository.deleteById(id);
    }

    @Override
    public Proyectos buscarProyectos(Long id) {
        return proyectosRepository.findById(id).orElse(null);
    }

    @Override
    public boolean existsById(Long id) {
        return proyectosRepository.existsById(id);

    }

    @Override
    public Optional<Proyectos> getOne(Long id) {
        return proyectosRepository.findById(id);
    }
    
}
