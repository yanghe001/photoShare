package core.service.impl;

import core.dao.ImageDao;
import core.dao.LoveDao;
import core.dao.SortDao;
import core.pojo.Image;
import core.pojo.Sort;
import core.results.PageInfo;
import core.service.ImageService;
import core.utils.FileUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageDao imageDao;
    @Autowired
    LoveDao loveDao;
    @Autowired
    SortDao sortDao;

    @Override
    public int insertImage(Image image) {
        return imageDao.insertImage(image);
    }

    @Override
    public List<Image> findAllImageByOrderCountDESCPage(PageInfo pageInfo) {
        return imageDao.findAllImageByOrderCountDESCPage(pageInfo);
    }

    @Override
    public List<Image> findImageBySortNameCover() {
        List<Image> images=new ArrayList<>();
        List<Sort> sorts=sortDao.findAllSort();
        for(Sort s :sorts){
            Image image=new Image();
            image=imageDao.findImageBySortNamePraiseCountMax(s.getName());
            if(image!=null){
                images.add(image);
            }
        }
        return images;
    }

    @Override
    public List<Image> findImageBySortNamePage(String sort_name, PageInfo pageInfo) {
        return imageDao.findImageBySortNamePage(sort_name,pageInfo);
    }

    @Override
    public List<Image> findImageBySortNameAndUserNameCover(String user_name) {
        List<Image> images=new ArrayList<>();
        List<Sort> sorts=sortDao.findAllSort();
        for(Sort s :sorts){
            Image image=new Image();
            image=imageDao.findImageBySortNameAndUserNamePraiseCountMax(s.getName(),user_name);
            if(image!=null){
                images.add(image);
            }
        }
        return images;
    }

    @Override
    public List<Image> findImageListBySortNameAndUserNamePage(String sort_name, String user_name,PageInfo pageInfo) {
        return imageDao.findImageListBySortNameAndUserNamePage(sort_name,user_name,pageInfo);
    }

    @Override
    public boolean deleteImageById(int id) {
        List<Integer> ids= Arrays.asList(id);
        List<String> paths= imageDao.findImgPathsByIds(ids);
        FileUntil.deleteManyFile(paths);
        int result= imageDao.deleteImageById(id);
        loveDao.deleteLoveByImgId(id);
        return result>0?true:false;
    }

    @Override
    public boolean deleteManyImageByIds(List<Integer> ids) {
        List<String> paths= imageDao.findImgPathsByIds(ids);
        FileUntil.deleteManyFile(paths);
        int result=imageDao.deleteManyImageByIds(ids);
        loveDao.deleteManyImageByIds(ids);
        return result>0?true:false;
    }


    @Override
    public int deleteImageByUserName(String user_name) {
        return imageDao.deleteImageByUserName(user_name);
    }

    @Override
    public List<Image> findAllImagePage(PageInfo pageInfo) {
        return imageDao.findAllImagePage(pageInfo);
    }


    @Override
    public int updateImageById(Image image) {
        return imageDao.updateImageById(image);
    }

    @Override
    public int addPraiseImage(int id) {
        return imageDao.addPraiseImage(id);
    }

    @Override
    public int delPraiseImage(int id) {
        return imageDao.delPraiseImage(id);
    }

    @Override
    public List<Image> findLoveImageByUserName(List<Integer> ids) {
        return imageDao.findLoveImageByUserName(ids);
    }
}
