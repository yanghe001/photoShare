package core.controller;

import com.alibaba.fastjson.JSONObject;
import core.pojo.User;
import core.results.CodeMsg;
import core.results.PageInfo;
import core.results.PageResult;
import core.service.LoginService;
import core.service.UserService;
import core.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(allowCredentials="true",allowedHeaders="*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    LoginService loginService;

    /**
     * 添加用户
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/insertUser",method=RequestMethod.POST)
    public CodeMsg insertUser(@RequestBody JSONObject jsonObject){
        User user=(User)JSONObject.toJavaObject(jsonObject,User.class);
        if(userService.findUserIsExitByName(user.getName())!=null){
            return CodeMsg.REGISTER_NAME_EXIT;
        }
        user.setPassword(Md5Util.saltAndMd5(user.getPassword()));
        int result=userService.insertUser(user);
        return result>0?CodeMsg.SUCCESS:CodeMsg.ERROR;
    }


    /**
     * 删除用户
     * @param name
     * @return
     */
    @RequestMapping(value = "/deleteUserByName",method=RequestMethod.POST)
    public CodeMsg deleteUserByName(@RequestParam(name = "name") String name){
        return userService.deleteUserByName(name)?CodeMsg.SUCCESS:CodeMsg.ERROR;
    }


    /**
     * 查找用户
     * @param name
     * @return
     */
    @RequestMapping(value = "/findUserByName",method=RequestMethod.POST)
    public User findUserByName(@RequestParam(name = "name")  String name){
        User user=userService.findUserByName(name);
        return user;
    }

    /**
     * 查找所有普通用户
     * @param params
     * @return
     */
    @RequestMapping(value = "/findAllUserByPage",method=RequestMethod.POST)
    public PageResult<User> findAllUserByPage(@RequestParam Map<String, Object> params){
        PageInfo pageInfo=new PageInfo();
        pageInfo.setPageSize(Integer.valueOf(params.get("pageSize").toString()));
        pageInfo.setCurrentPage(Integer.valueOf(params.get("currentPage").toString()));
        System.out.println(pageInfo);
        List<User> users=userService.findAllUserByPage(pageInfo);
        PageResult<User> pageResult=new PageResult<>();
        pageResult.setPageInfo(pageInfo);
        pageResult.setRow(users);
        return pageResult;
    }

    /**
     * 更新用户信息
     * @param user
     * @param req
     * @return
     */
    @RequestMapping(value = "/updateUserByName",method=RequestMethod.POST)
    public User updateUserByName(@ModelAttribute("userInfo") User user, HttpServletRequest req){
        if(user.getPassword()!=null||!user.getPassword().equals("")){
            String newPass=Md5Util.saltAndMd5(user.getPassword());
            user.setPassword(newPass);
        }
        System.out.println(user);
        int result=userService.updateUserByName(user);
        req.getSession().removeAttribute("user");
        req.getSession().setAttribute("user",user);
        return result>0?user:null;
    }


    /**
     * 重置密码
     * @param name
     * @return
     */
    @RequestMapping("/resetUserPassByName")
    public CodeMsg resetUserPassByName(@RequestParam(name = "name") String name){
        int result=userService.resetUserPassByName(name);
        return result>0?CodeMsg.SUCCESS:CodeMsg.ERROR;
    }
}
