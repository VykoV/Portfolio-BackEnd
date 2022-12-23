package com.argprog.portfolio.Interface;

import com.argprog.portfolio.entity.Educacion;
import java.util.List;

public interface IEducacionService {
    public List<Educacion> verEducacion();
    public void crearEducacion (Educacion educa);
    public void borrarEducacion (Long id);
    public Educacion buscarEducacion (Long id);
}
