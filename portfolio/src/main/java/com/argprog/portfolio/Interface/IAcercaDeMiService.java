package com.argprog.portfolio.Interface;

import com.argprog.portfolio.entity.AcercaDeMi;
import java.util.List;

public interface IAcercaDeMiService {
    public List<AcercaDeMi> verAcercaDeMi();
    public void crearAcercaDeMi (AcercaDeMi adm);
    public void borrarAcercaDeMi (Long id);
    public AcercaDeMi buscarAcercaDeMi(Long id);
}
