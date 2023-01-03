package com.argprog.portfolio.service;

import com.argprog.portfolio.Interface.IHardSkillFrontEndService;
import com.argprog.portfolio.entity.HardSkillFrontEnd;
import com.argprog.portfolio.repository.HardSkillFrontEndRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HardSkillFrontEndService implements IHardSkillFrontEndService{
    @Autowired
    public HardSkillFrontEndRepository hardSkillFrontEndRepository; 
    @Override
    public List<HardSkillFrontEnd> verHardSkillFrontEnd() {
        return hardSkillFrontEndRepository.findAll();
    }

    @Override
    public void crearHardSkillFrontEnd(HardSkillFrontEnd hsfe) {
        hardSkillFrontEndRepository.save(hsfe);
    }

    @Override
    public void borrarHardSkillFrontEnd(Long id) {
        hardSkillFrontEndRepository.deleteById(id);
    }

    @Override
    public HardSkillFrontEnd buscarHardSkillFrontEnd(Long id) {
        return hardSkillFrontEndRepository.findById(id).orElse(null);
    }

    @Override
    public boolean existsById(Long id) {
        return hardSkillFrontEndRepository.existsById(id);

    }

    @Override
    public Optional<HardSkillFrontEnd> getOne(Long id) {
        return hardSkillFrontEndRepository.findById(id);

    }
    
}
