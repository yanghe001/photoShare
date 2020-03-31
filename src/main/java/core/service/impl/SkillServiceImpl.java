package core.service.impl;

import core.dao.SkillDao;
import core.pojo.Skill;
import core.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {
    @Autowired
    SkillDao skillDao;


    @Override
    public boolean insertSkill(Skill skill) {
        return skillDao.insertSkill(skill)>0?true:false;
    }

    @Override
    public boolean deleteSkillById(int id) {
        return skillDao.deleteSkillById(id)>0?true:false;
    }

    @Override
    public List<Skill> findAllSkill() {
        return skillDao.findAllSkill();
    }

    @Override
    public boolean updateSkillById(Skill skill) {
        return skillDao.updateSkillById(skill)>0?true:false;
    }
}
