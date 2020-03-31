package core.dao;

import core.pojo.DynamicLove;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DynamicLoveDao {

    //插入点赞
    int insertDynamicLove(DynamicLove dynamicLove);

    //查询点赞是否存在
    DynamicLove findIsExistDynamicLove(String user_name, Integer dynamic_id);

    //记录点赞/或者取消点赞
    int updateAddDynamicLove(String user_name, Integer dynamic_id);

    int updateDelDynamicLove(String user_name, Integer dynamic_id);

    //删除点赞通过动态id
    int deleteDynamicLoveByDynamicId(Integer dynamic_id);

    //查询点赞过所有动态id
    List<Integer> findDynamicIdsByUserName(String user_name);
}
