package core.dao;

import core.pojo.Image;
import core.results.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ImageDao {

    //添加图片
    int insertImage(Image image);

    //获取首页图片集 按照点赞排行
    List<Image> findAllImageByOrderCountDESCPage(PageInfo pageInfo);

    //根据分类获取该类推荐封面 按照点赞排行
    Image findImageBySortNamePraiseCountMax(String sort_name);

    //获取每个分类图片集 按照点赞排行
    List<Image> findImageBySortNamePage(String sort_name,PageInfo pageInfo);

    //获取用户每类图集封面
    Image findImageBySortNameAndUserNamePraiseCountMax(String sort_name,String user_name);

    //根据类型获取该用户图集
    List<Image> findImageListBySortNameAndUserNamePage(String sort_name,String user_name,PageInfo pageInfo);

    //根据图片id删除图片
    int deleteImageById(int id);
    //删除多个图片 根据ids
    int deleteManyImageByIds(@Param("ids") List<Integer> ids);
    //根据图片id查找图片路径
    List<String> findImgPathsByIds(@Param("ids") List<Integer> ids);

    //根据类型删除图片
    int deleteImageBySortName(String sort_name);
    //获取分类所有图片的路径 删除图片
    List<String> findUrlsBySortName(String user_name);

    //删除用户时把图片删除
    int deleteImageByUserName(String user_name);
    //获取用户所有图片的路径 删除图片
    List<String> findUrlsByUserName(String user_name);


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
