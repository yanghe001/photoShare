package core.dao;

import core.pojo.Skill;
import core.results.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SkillDao {
    //添加上传技巧
    int insertSkill(Skill skill);

    //删除上传技巧
    int deleteSkillById(int id);

    //根据分类删除技巧
    int deleteSkillBySortName(String sort_name);

   //根据分类获取技巧集
   List<Skill> findSkillListBySortName(String sort_name);

    //更新技巧信息
    int updateSkillById(Skill skill);
}
