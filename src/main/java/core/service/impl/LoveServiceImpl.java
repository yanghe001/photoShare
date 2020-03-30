package core.service.impl;

import core.dao.ImageDao;
import core.dao.LoveDao;
import core.pojo.Image;
import core.pojo.Love;
import core.service.LoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoveServiceImpl implements LoveService {
    @Autowired
    LoveDao loveDao;
    @Autowired
    ImageDao imageDao;

    @Override
    public boolean addOrDelLove(Love love,String user_name) {
        int result=0;
        int result2=0;
        if(loveDao.findLoveIsExistByImgIdAndUserNameAndSortName(love.getImg_id(),user_name,love.getSort_name())==null){
            love.setUser_name(user_name);
            result=imageDao.addPraiseImage(love.getImg_id());
            result2=loveDao.insetLove(love);
        }else{
            result=imageDao.delPraiseImage(love.getImg_id());
            result2= loveDao.deleteLoveByImgIdAndUserNameAndSortName(love.getImg_id(),user_name,love.getSort_name());
        }
        return result>0&result2>0?true:false;
    }

    @Override
    public List<Image> findLove(String user_name) {
        List<Integer> ids=loveDao.findLoveByName(user_name);
        if(ids.size()<1){
            return null;
        }else{
            return imageDao.findLoveImageByUserName(ids);
        }
    }


    @Override
    public int deleteLoveByUserName(String user_name) {
        return loveDao.deleteLoveByUserName(user_name);
    }


    @Override
    public List<Integer> findLoveByName(String user_name) {
        return loveDao.findLoveByName(user_name);
    }

}
