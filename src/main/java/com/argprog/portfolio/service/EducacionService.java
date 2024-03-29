package com.argprog.portfolio.service;

import com.argprog.portfolio.Interface.IEducacionService;
import com.argprog.portfolio.entity.Educacion;
import com.argprog.portfolio.repository.EducacionRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService implements IEducacionService {
    
    @Autowired 
    public EducacionRepository educacionRepository;
     
    @Override
    public List<Educacion> verEducacion() {
        return educacionRepository.findAll(); 
    }
    
    @Override
    public void crearEducacion(Educacion educa){
        educacionRepository.save(educa);
    }
    
    @Override
    public void borrarEducacion(Long id) {
        educacionRepository.deleteById(id);
    }

    @Override
    public Educacion buscarEducacion(Long id) {
        return educacionRepository.findById(id).orElse(null);
    }

    @Override
    public boolean existencia(Long id) {
        return educacionRepository.existsById(id);
    }

    @Override
    public Optional<Educacion> uno(Long id) {
        return educacionRepository.findById(id);
    }
    
}
