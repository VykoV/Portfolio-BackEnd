package com.argprog.portfolio.repository;

import com.argprog.portfolio.entity.AcercaDeMi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcercaDeMiRepository extends JpaRepository <AcercaDeMi,Long> {
    
}
