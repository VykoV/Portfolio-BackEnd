package com.argprog.portfolio.repository;

import com.argprog.portfolio.entity.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectosRepository extends JpaRepository<Proyectos,Long> {
    
}
