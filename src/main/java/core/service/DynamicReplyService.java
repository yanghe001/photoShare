package core.service;

import core.pojo.DynamicReply;

import java.util.List;

public interface DynamicReplyService {
    //插入回复
    boolean insertDynamicReply(DynamicReply dynamicReply);

    //查询某条评论下的所有回复
    List<DynamicReply> findCommentDynamicReply(Integer comment_id, Integer dynamic_id);

    //查询某条回复下的所有回复
    List<DynamicReply> findReplyDynamicReply(Integer comment_id,Integer dynamic_id,String to_user);
}
