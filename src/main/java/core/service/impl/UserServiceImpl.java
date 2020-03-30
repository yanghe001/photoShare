package core.service.impl;

import core.dao.ImageDao;
import core.dao.LoveDao;
import core.dao.UserDao;
import core.pojo.User;
import core.results.PageInfo;
import core.service.UserService;
import core.utils.FileUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    ImageDao imageDao;
    @Autowired
    LoveDao loveDao;


    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public boolean deleteUserByName(String name) {
        List<String> paths=imageDao.findUrlsByUserName(name);
        FileUntil.deleteManyFile(paths);
        imageDao.deleteImageByUserName(name);
        loveDao.deleteLoveByUserName(name);
        int result= userDao.deleteUserByName(name);
        return result>0?true:false;
    }

    @Override
    public String findUserIsExitByName(String name) {
        return userDao.findUserIsExitByName(name);
    }

    @Override
    public User findUserByName(String name) {
        return userDao.findUserByName(name);
    }

    @Override
    public List<User> findAllUserByPage(PageInfo pageInfo) {
        return userDao.findAllUserByPage(pageInfo);
    }

    @Override
    public int updateUserByName(User user) {
        return userDao.updateUserByName(user);
    }

    @Override
    public int resetUserPassByName(String name) {
        return userDao.resetUserPassByName(name);
    }
}
