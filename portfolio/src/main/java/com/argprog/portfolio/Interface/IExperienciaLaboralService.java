package com.argprog.portfolio.Interface;

import com.argprog.portfolio.entity.ExperienciaLaboral;
import java.util.List;

public interface IExperienciaLaboralService {
    public List<ExperienciaLaboral> verExperienciaLaboral();
    public void crearExperienciaLaboral (ExperienciaLaboral el);
    public void borrarExperienciaLaboral (Long id);
    public ExperienciaLaboral buscarExperienciaLaboral (Long id);
}
