package core.service;

import core.pojo.Image;
import core.results.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImageService {
    //添加图片
    int insertImage(Image image);

    //获取首页图片集 按照点赞排行
    List<Image> findAllImageByOrderCountDESCPage(PageInfo pageInfo);

    //获取分类推荐封面 按照点赞排行
    List<Image> findImageBySortNameCover();

    //获取每个分类图片集 按照点赞排行
    List<Image> findImageBySortNamePage(String sort_name,PageInfo pageInfo);

    //获取用户每类图集封面
    List<Image> findImageBySortNameAndUserNameCover(String user_name);

    //根据类型获取该用户图集
    List<Image> findImageListBySortNameAndUserNamePage(String sort_name,String user_name,PageInfo pageInfo);

    //根据图片id删除图片
    boolean deleteImageById(int id);

    //删除多个图片 根据ids
    boolean deleteManyImageByIds(@Param("ids") List<Integer> ids);

    //删除用户时把图片删除
    int deleteImageByUserName(String user_name);

    //查找所有图片 按点赞排行
    List<Image> findAllImagePage(PageInfo pageInfo);

    //更新图片
    int updateImageById(Image image);

    //love 点赞
    int addPraiseImage(int id);
    int delPraiseImage(int id);

    //love 我喜欢的图片
    List<Image> findLoveImageByUserName(@Param("ids") List<Integer> ids);
}
