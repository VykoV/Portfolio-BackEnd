package com.argprog.portfolio.Interface;

import com.argprog.portfolio.entity.SoftSkill;
import java.util.List;
import java.util.Optional;

public interface ISoftSkillService {
    public List<SoftSkill> verSoftSkill();
    public void crearSoftSkill (SoftSkill ss);
    public void borrarSoftSkill (Long id);
    public SoftSkill buscarSoftSkill(Long id);
    public boolean existsById(Long id);
    public Optional<SoftSkill> getOne(Long id);
}
