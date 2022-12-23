package com.argprog.portfolio.Interface;

import com.argprog.portfolio.entity.HardSkillFrontEnd;
import java.util.List;


public interface IHardSkillFrontEndService {
    public List<HardSkillFrontEnd> verHardSkillFrontEnd();
    public void crearHardSkillFrontEnd (HardSkillFrontEnd hsfe);
    public void borrarHardSkillFrontEnd (Long id);
    public HardSkillFrontEnd buscarHardSkillFrontEnd(Long id);
}
