package core.dao;

import core.pojo.User;
import core.results.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    //添加用户
    int insertUser(User user);

    /*
        删除用户通过name
     */
    int deleteUserByName(String name);


    /*
        查询该name是否存在
        查询用户通过name
        分页查询
     */
    String findUserIsExitByName(String name);
    User findUserByName(String name);
    List<User> findAllUserByPage(PageInfo pageInfo);

    /*
        更新用户信息
        重置用户密码
     */
    int updateUserByName(User user);
    int resetUserPassByName(String name);

}
