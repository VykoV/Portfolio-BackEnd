package com.argprog.portfolio.service;

import com.argprog.portfolio.Interface.IAcercaDeMiService;
import com.argprog.portfolio.entity.AcercaDeMi;
import com.argprog.portfolio.repository.AcercaDeMiRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AcercaDeMiService implements IAcercaDeMiService {

    @Autowired AcercaDeMiRepository acercaDeMiRepository;

    @Override
    public List<AcercaDeMi> verAcercaDeMi() {
        return acercaDeMiRepository.findAll();    
    }

    @Override
    public void crearAcercaDeMi(AcercaDeMi adm) {
        acercaDeMiRepository.save(adm);    
    }

    @Override
    public void borrarAcercaDeMi(Long id) {
      acercaDeMiRepository.deleteById(id);
    }

    @Override
    public AcercaDeMi buscarAcercaDeMi(Long id) {
        return acercaDeMiRepository.findById(id).orElse(null);
    }

    @Override
    public boolean existsById(Long id) {
        return acercaDeMiRepository.existsById(id);
}

    @Override
    public Optional<AcercaDeMi> getOne(Long id) {
        return acercaDeMiRepository.findById(id);
}
}
