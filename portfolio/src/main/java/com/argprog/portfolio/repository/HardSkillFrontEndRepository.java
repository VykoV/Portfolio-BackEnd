
package com.argprog.portfolio.repository;

import com.argprog.portfolio.entity.HardSkillFrontEnd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardSkillFrontEndRepository extends JpaRepository<HardSkillFrontEnd,Long> {
    
}
