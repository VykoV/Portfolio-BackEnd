package com.argprog.portfolio.repository;

import com.argprog.portfolio.entity.SoftSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftSkillRepository extends JpaRepository<SoftSkill,Long>{
    
}
