package core.service;

import core.pojo.DynamicComment;

import java.util.List;

public interface DynamicCommentService {

    //添加评论
    boolean insertDynamicComment(DynamicComment dynamicComment);

    //获取某条动态下的评论  通过动态的id
    List<DynamicComment> findCommentByDynamicId(Integer dynamic_id);

    //通过 动态id删除
    boolean deleteCommentByDynamicId(Integer dynamic_id);
}
