package com.argprog.portfolio.repository;

import com.argprog.portfolio.entity.HardSkillBackEnd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardSkillBackEndRepository extends JpaRepository<HardSkillBackEnd, Long> {
    
}
