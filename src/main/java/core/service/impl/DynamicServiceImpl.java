package core.service.impl;

import core.dao.DynamicDao;
import core.dao.DynamicLoveDao;
import core.pojo.Dynamic;
import core.results.PageInfo;
import core.service.DynamicService;
import core.utils.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DynamicServiceImpl implements DynamicService {

    @Autowired
    DynamicDao dynamicDao;
    @Autowired
    DynamicLoveDao dynamicLoveDao;
    @Override
    public boolean insertDynamic(Dynamic dynamic) {
        int result=dynamicDao.insertDynamic(dynamic);
        return result>0?true:false;
    }

    @Override
    public boolean deleteDynamicById(Integer id) {
        int result=dynamicDao.deleteDynamicById(id);
        dynamicLoveDao.deleteDynamicLoveByDynamicId(id);
        return result>0?true:false;
    }

    @Override
    public List<Dynamic> findDynamicByUserNamePage(String user_name, PageInfo pageInfo) {
        List<Integer> dynamicIds=dynamicLoveDao.findDynamicIdsByUserName(user_name);
        List<Dynamic> dynamics=praiseTool(dynamicDao.findDynamicByUserNamePage(user_name,pageInfo),dynamicIds);
        return dynamics;
    }

    @Override
    public List<Dynamic> findDynamicAllPage(String user_name, PageInfo pageInfo) {
        List<Dynamic> list=dynamicDao.findDynamicAllPage(pageInfo);
        if(user_name.equals("")||user_name.length()==0){
            return list;
        }else{
            List<Integer> dynamicIds=dynamicLoveDao.findDynamicIdsByUserName(user_name);
            List<Dynamic> dynamics=praiseTool(list,dynamicIds);
            return dynamics;
        }
    }


    /**
     * 处理动态是否点赞 处理图片链接
     * @param dynamics
     * @param ids
     * @return
     */
    @Value("${diy.httpTop}")
    private String httpTop;
    public List<Dynamic> praiseTool(List<Dynamic> dynamics, List<Integer> ids){
        if(dynamics.size()<1){
            return null;
        }
        for(Dynamic dynamic : dynamics){
            if(ids.size()>0){
                if(ids.contains(dynamic.getId())){
                    dynamic.setFlag(true);
                }
            }
            //拼接请求链接
            List<String> imagesList=new ArrayList<>();
            String str=dynamic.getImages();
            List<String> stringList= Context.splitString(str,",");
            for(String string :stringList){
                imagesList.add(httpTop+string);
            }
            dynamic.setImageUrlList(imagesList);
        }
        return dynamics;
    }
}
