package core.dao;

import core.pojo.Love;
import core.results.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LoveDao {

    //判断是否存在我喜欢
    String findLoveIsExistByImgIdAndUserNameAndSortName(int img_id,String user_name,String sort_name);
    //添加我喜欢的
    int insetLove(Love love);
    //删除我喜欢的
    int deleteLoveByImgIdAndUserNameAndSortName(int img_id,String user_name,String sort_name);

    //查找我喜欢的图片id
    List<Integer> findLoveByName(String user_name);

    //删除喜欢的图片根据 单个img_id
    int deleteLoveByImgId(int img_id);

    //删除喜欢的图片根据 多个img_id
    int deleteManyImageByIds(@Param("ids") List<Integer> ids);

    //根据类型删除喜欢
    int deleteLoveBySortName(String sort_name);

    //根据用户删除喜欢的
    int deleteLoveByUserName(String user_name);

}
