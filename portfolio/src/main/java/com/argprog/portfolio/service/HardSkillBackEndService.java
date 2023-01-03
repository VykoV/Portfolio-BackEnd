package com.argprog.portfolio.service;

import com.argprog.portfolio.Interface.IHardSkillBackEndService;
import com.argprog.portfolio.entity.HardSkillBackEnd;
import com.argprog.portfolio.repository.HardSkillBackEndRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HardSkillBackEndService implements IHardSkillBackEndService {

    @Autowired
    public HardSkillBackEndRepository hardSkillBackEndRepository;

    @Override
    public List<HardSkillBackEnd> verHardSkillBackEnd() {
        return hardSkillBackEndRepository.findAll();
    }

    @Override
    public void crearHardSkillBackEnd(HardSkillBackEnd hsbe) {
        hardSkillBackEndRepository.save(hsbe);

    }

    @Override
    public void borrarHardSkillBackEnd(Long id) {
        hardSkillBackEndRepository.deleteById(id);
    }

    @Override
    public HardSkillBackEnd buscarHardSkillBackEnd(Long id) {
        return hardSkillBackEndRepository.findById(id).orElse(null);
    }

    @Override
    public boolean existsById(Long id) {
        return hardSkillBackEndRepository.existsById(id);

    }

    @Override
    public Optional<HardSkillBackEnd> getOne(Long id) {
        return hardSkillBackEndRepository.findById(id);

    }

}
