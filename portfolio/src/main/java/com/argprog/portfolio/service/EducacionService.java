package com.argprog.portfolio.service;

import com.argprog.portfolio.Interface.IEducacionService;
import com.argprog.portfolio.entity.Educacion;
import com.argprog.portfolio.repository.EducacionRepository;
import jakarta.transaction.Transactional;

import java.util.List;
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
    
}
