package com.argprog.portfolio.service;

import com.argprog.portfolio.Interface.IPersonaService;
import com.argprog.portfolio.entity.Persona;
import com.argprog.portfolio.repository.PersonaRepository;
import jakarta.transaction.Transactional; 

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonaServise implements IPersonaService { 
    
    @Autowired
    public PersonaRepository persoRepo;
    
    @Override
    public List<Persona> verPersonas() {
        return persoRepo.findAll();
    }

    @Override
    public void crearPersona(Persona per) {
        persoRepo.save(per);
    }

    @Override
    public void borrarPersona(Long id) {
        persoRepo.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id) {
        return persoRepo.findById(id).orElse(null);
    }
    
    
}
