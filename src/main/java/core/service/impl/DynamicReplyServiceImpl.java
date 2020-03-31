package core.service.impl;

import core.dao.DynamicReplyDao;
import core.pojo.DynamicReply;
import core.service.DynamicReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DynamicReplyServiceImpl implements DynamicReplyService {

    @Autowired
    DynamicReplyDao dynamicReplyDao;
    @Override
    public boolean insertDynamicReply(DynamicReply dynamicReply) {
        return dynamicReplyDao.insertDynamicReply(dynamicReply)>0?true:false;
    }

    @Override
    public List<DynamicReply> findCommentDynamicReply(Integer comment_id, Integer dynamic_id) {
        return dynamicReplyDao.findCommentDynamicReply(comment_id,dynamic_id);
    }

    @Override
    public List<DynamicReply> findReplyDynamicReply(Integer comment_id, Integer dynamic_id, String to_user) {
        return dynamicReplyDao.findReplyDynamicReply(comment_id,dynamic_id,to_user);
    }
}
