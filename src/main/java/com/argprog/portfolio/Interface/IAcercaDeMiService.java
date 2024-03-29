package com.argprog.portfolio.Interface;

import com.argprog.portfolio.entity.AcercaDeMi;
import java.util.List;
import java.util.Optional;

public interface IAcercaDeMiService {
    public List<AcercaDeMi> verAcercaDeMi();
    public void crearAcercaDeMi (AcercaDeMi adm);
    public void borrarAcercaDeMi (Long id);
    public AcercaDeMi buscarAcercaDeMi(Long id);
    public boolean existencia(Long id);
    public Optional<AcercaDeMi> uno(Long id);
}
