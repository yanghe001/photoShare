package core.dao;

import core.pojo.DynamicComment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DynamicCommentDao {

    //插入评论
    int insertDynamicComment(DynamicComment dynamicComment);

    //通过动态id查询该动态的评论
    List<DynamicComment> findCommentByDynamicId(Integer dynamic_id);

    //通过 动态id删除
    int deleteCommentByDynamicId(Integer dynamic_id);


}
