package core.service;

import core.pojo.Image;
import core.pojo.Love;
import core.results.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoveService {

    //点赞或者删除我喜欢的
    boolean addOrDelLove(Love love,String user_name);

    //查看我喜欢的
    List<Image> findLove(String user_name);

    //查找我喜欢的图片id
    List<Integer> findLoveByName(String user_name);

    //根据用户删除喜欢的
    int deleteLoveByUserName(String user_name);

}
