package core.service.impl;

import core.dao.DynamicDao;
import core.dao.DynamicLoveDao;
import core.pojo.DynamicLove;
import core.service.DynamicLoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DynamicLoveServiceImpl implements DynamicLoveService {
    @Autowired
    DynamicLoveDao dynamicLoveDao;
    @Autowired
    DynamicDao dynamicDao;

    @Override
    public boolean addOrDelDynamicLove(String user_name, Integer dynamic_id) {
        int result=0;
        if(dynamicLoveDao.findIsExistDynamicLove(user_name,dynamic_id)!=null){
            DynamicLove dynamicLove=dynamicLoveDao.findIsExistDynamicLove(user_name,dynamic_id);
            int flag=dynamicLove.getFlag();
            if(flag==0){
                dynamicDao.updateAddDynamicPraiseCount(dynamic_id);
                result=dynamicLoveDao.updateAddDynamicLove(user_name,dynamic_id);
            }else{
                dynamicDao.updateDelDynamicPraiseCount(dynamic_id);
                result= dynamicLoveDao.updateDelDynamicLove(user_name,dynamic_id);
            }
        }else{
            dynamicDao.updateAddDynamicPraiseCount(dynamic_id);
            DynamicLove dynamicLove=new DynamicLove();
            dynamicLove.setUser_name(user_name);
            dynamicLove.setDynamic_id(dynamic_id);
            result=dynamicLoveDao.insertDynamicLove(dynamicLove);
        }
        return result>0?true:false;
    }
}
