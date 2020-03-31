package core.dao;


import core.pojo.DynamicReply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DynamicReplyDao {

    //插入回复
    int insertDynamicReply(DynamicReply dynamicReply);

    //查询某条评论下的所有回复
    List<DynamicReply> findCommentDynamicReply(Integer comment_id,Integer dynamic_id);

    //查询某条回复下的所有回复
    List<DynamicReply> findReplyDynamicReply(Integer comment_id,Integer dynamic_id,String to_user);


}
