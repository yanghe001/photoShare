package core.service;

import core.pojo.User;
import core.results.PageInfo;

import java.util.List;

public interface UserService {

    //添加用户
    int insertUser(User user);

    /*
        删除用户通过name
        批量删除用户
     */
    boolean deleteUserByName(String name);

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
