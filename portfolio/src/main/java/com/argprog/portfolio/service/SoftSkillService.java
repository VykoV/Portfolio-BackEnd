package com.argprog.portfolio.service;

import com.argprog.portfolio.Interface.ISoftSkillService;
import com.argprog.portfolio.entity.SoftSkill;
import com.argprog.portfolio.repository.SoftSkillRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SoftSkillService implements ISoftSkillService{
    @Autowired 
    public SoftSkillRepository softSkillRepository;
    
    @Override
    public List<SoftSkill> verSoftSkill() {
        return softSkillRepository.findAll();
    }

    @Override
    public void crearSoftSkill(SoftSkill ss) {
        softSkillRepository.save(ss);
    }

    @Override
    public void borrarSoftSkill(Long id) {
        softSkillRepository.deleteById(id);
    }

    @Override
    public SoftSkill buscarSoftSkill(Long id) {
        return softSkillRepository.findById(id).orElse(null);
    }
}
