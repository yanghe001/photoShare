package core.service.impl;

import core.dao.SkillDao;
import core.dao.SortDao;
import core.pojo.Image;
import core.pojo.Skill;
import core.pojo.Sort;
import core.results.PageInfo;
import core.service.SkillService;
import core.utils.FileUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class SkillServiceImpl implements SkillService {
    @Autowired
    SkillDao skillDao;

    @Override
    public int insertSkill(Skill skill) {
        return skillDao.insertSkill(skill);
    }

    @Override
    public int deleteSkillById(int id) {
        return skillDao.deleteSkillById(id);
    }

    @Override
    public int deleteSkillBySortName(String sort_name) {
        return skillDao.deleteSkillBySortName(sort_name);
    }

    @Override
    public List<Skill> findSkillListBySortName(String sort_name) {
        return skillDao.findSkillListBySortName(sort_name);
    }

    @Override
    public int updateSkillById(Skill skill) {
        return skillDao.updateSkillById(skill);
    }
}
