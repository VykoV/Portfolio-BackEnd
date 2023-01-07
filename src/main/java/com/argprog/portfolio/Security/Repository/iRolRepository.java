
package com.argprog.portfolio.Security.Repository;

import com.argprog.portfolio.Security.entity.Rol;
import com.argprog.portfolio.Security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre (RolNombre rolNombre);
}
