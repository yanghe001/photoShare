package core.service;

import core.pojo.Dynamic;
import core.results.PageInfo;

import java.util.List;

public interface DynamicService {
    //插入动态
    boolean insertDynamic(Dynamic dynamic);

    //删除动态
    boolean deleteDynamicById(Integer id);

    //获取用户动态
    List<Dynamic> findDynamicByUserNamePage(String user_name, PageInfo pageInfo);

    //获取所有动态
    List<Dynamic> findDynamicAllPage(String user_name, PageInfo pageInfo);
}
