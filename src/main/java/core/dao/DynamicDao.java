package core.dao;

import core.pojo.Dynamic;
import core.results.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DynamicDao {

    //插入动态
    int insertDynamic(Dynamic dynamic);

    //删除动态
    int deleteDynamicById(Integer id);

    //获取用户动态
    List<Dynamic> findDynamicByUserNamePage(String user_name, PageInfo pageInfo);

    //获取所有动态
    List<Dynamic> findDynamicAllPage(PageInfo pageInfo);



    //更改点赞数量 -
    int updateDelDynamicPraiseCount(String user_name, Integer id);

    //更改点赞数量 +
    int updateAddDynamicPraiseCount(String user_name, Integer dynamic_id);
}
