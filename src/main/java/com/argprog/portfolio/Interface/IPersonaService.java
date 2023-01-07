package com.argprog.portfolio.Interface;

import com.argprog.portfolio.entity.Persona;
import java.util.List;
import java.util.Optional;

public interface IPersonaService {
    public List<Persona> verPersonas();
    public void crearPersona (Persona per);
    public void borrarPersona (Long id);
    public Persona buscarPersona(Long id);
    public boolean existencia(Long id);
    public Optional<Persona> uno(Long id);
}
