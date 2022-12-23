package com.argprog.portfolio.Interface;

import com.argprog.portfolio.entity.HardSkillBackEnd;
import java.util.List;

public interface IHardSkillBackEndService {
    public List<HardSkillBackEnd> verHardSkillBackEnd();
    public void crearHardSkillBackEnd (HardSkillBackEnd hsbe);
    public void borrarHardSkillBackEnd (Long id);
    public HardSkillBackEnd buscarHardSkillBackEnd(Long id);
}
