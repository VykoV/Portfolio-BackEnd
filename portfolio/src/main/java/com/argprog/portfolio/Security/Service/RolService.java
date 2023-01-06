package com.argprog.portfolio.Security.Service;

import com.argprog.portfolio.Security.Repository.iRolRepository;
import com.argprog.portfolio.Security.entity.Rol;
import com.argprog.portfolio.Security.enums.RolNombre;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {

    @Autowired
    iRolRepository irolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return irolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol) {
        irolRepository.save(rol);
    }
}
