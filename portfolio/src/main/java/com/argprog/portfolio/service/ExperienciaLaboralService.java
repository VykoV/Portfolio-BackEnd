package com.argprog.portfolio.service;

import com.argprog.portfolio.Interface.IExperienciaLaboralService;
import com.argprog.portfolio.entity.ExperienciaLaboral;
import com.argprog.portfolio.repository.ExperienciaLaboralRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional 
public class ExperienciaLaboralService implements IExperienciaLaboralService {
    @Autowired ExperienciaLaboralRepository experienciaLaboralRepository;
    @Override
    public List<ExperienciaLaboral> verExperienciaLaboral() {
        return experienciaLaboralRepository.findAll();
    }

    @Override
    public void crearExperienciaLaboral(ExperienciaLaboral el) {
        experienciaLaboralRepository.save(el);
    }

    @Override
    public void borrarExperienciaLaboral(Long id) {
        experienciaLaboralRepository.deleteById(id);
    }

    @Override
    public ExperienciaLaboral buscarExperienciaLaboral(Long id) {
        return experienciaLaboralRepository.findById(id).orElse(null);
    }
    
}
