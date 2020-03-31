package core.service;

import core.pojo.Skill;
import java.util.List;

public interface SkillService {
    //添加上传技巧
    boolean insertSkill(Skill skill);

    //删除上传技巧
    boolean deleteSkillById(int id);

    //获取所有技巧集
    List<Skill> findAllSkill();

    //更新技巧信息
    boolean updateSkillById(Skill skill);
}
