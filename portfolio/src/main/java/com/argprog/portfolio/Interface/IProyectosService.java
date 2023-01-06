package com.argprog.portfolio.Interface;

import com.argprog.portfolio.entity.Proyectos;
import java.util.List;
import java.util.Optional;

public interface IProyectosService {
    public List<Proyectos> verProyectos();
    public void crearProyectos (Proyectos proy);
    public void borrarProyectos (Long id);
    public Proyectos buscarProyectos(Long id);
    public boolean existencia(Long id);
    public Optional<Proyectos> uno(Long id);
}
