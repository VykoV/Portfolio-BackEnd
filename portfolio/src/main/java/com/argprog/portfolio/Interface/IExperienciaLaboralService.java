package com.argprog.portfolio.Interface;

import com.argprog.portfolio.entity.ExperienciaLaboral;
import java.util.List;
import java.util.Optional;

public interface IExperienciaLaboralService {
    public List<ExperienciaLaboral> verExperienciaLaboral();
    public void crearExperienciaLaboral (ExperienciaLaboral el);
    public void borrarExperienciaLaboral (Long id);
    public ExperienciaLaboral buscarExperienciaLaboral (Long id);
    public boolean existencia(Long id);
    public Optional<ExperienciaLaboral> uno(Long id);
}
