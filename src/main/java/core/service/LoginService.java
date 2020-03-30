package core.service;

import core.dao.UserDao;
import core.pojo.User;
import core.results.CodeMsg;
import core.utils.Md5Util;
import core.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class LoginService {
    @Autowired
    UserDao userDao;

    public User getUserByName(String name){return userDao.findUserByName(name);}

    public CodeMsg loginDeal(HttpServletRequest req,HttpServletResponse resp, LoginVo loginVo){
        if(loginVo==null){
            return CodeMsg.SERVER_ERROR;
        }
        String name=loginVo.getName();
        String formPass=loginVo.getPassword();
        User user=getUserByName(name);
        if(user==null){
            return CodeMsg.NAME_NOT_EXIST;
        }
        String dbPass=user.getPassword();
        String inputPass= Md5Util.saltAndMd5(formPass);
        if(!dbPass.equals(inputPass)){
            return CodeMsg.PASSWORD_ERROR;
        }
        String type=user.getType();
        req.getSession().setAttribute("user",user);
        return type.equals("1")?CodeMsg.LOGIN_USER_SUCCESS:CodeMsg.LOGIN_ADMIN_SUCCESS;
    }
}
