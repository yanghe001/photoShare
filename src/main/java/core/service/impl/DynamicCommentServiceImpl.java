package core.service.impl;

import core.dao.DynamicCommentDao;
import core.pojo.DynamicComment;
import core.service.DynamicCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DynamicCommentServiceImpl implements DynamicCommentService {
    @Autowired
    DynamicCommentDao dynamicCommentDao;

    @Override
    public boolean insertDynamicComment(DynamicComment dynamicComment) {
        return dynamicCommentDao.insertDynamicComment(dynamicComment)>0?true:false;
    }

    @Override
    public List<DynamicComment> findCommentByDynamicId(Integer dynamic_id) {
        return dynamicCommentDao.findCommentByDynamicId(dynamic_id);
    }

    @Override
    public boolean deleteCommentByDynamicId(Integer dynamic_id) {
        return dynamicCommentDao.deleteCommentByDynamicId(dynamic_id)>0?true:false;
    }
}
