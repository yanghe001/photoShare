package core.controller;

import core.pojo.User;
import core.results.CodeMsg;
import core.service.LoginService;
import core.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@CrossOrigin(allowCredentials="true",allowedHeaders="*")
public class LoginController {
    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    LoginService loginService;


    @RequestMapping(value = "/login" , method=RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/doLogin" ,method=RequestMethod.POST)
    @ResponseBody
    public CodeMsg doLogin(HttpServletRequest req,HttpServletResponse resp, @Validated @RequestBody LoginVo loginVo, BindingResult results){
        if (results.hasErrors()){
            return CodeMsg.BIND_ERROR.fillArgs(results.getFieldError().getDefaultMessage());
        }
        return loginService.loginDeal(req,resp,loginVo);
    }
    @RequestMapping(value = "/getUserInfo" , method=RequestMethod.POST)
    @ResponseBody
    public User getUserInfo(HttpServletRequest req){
        User user=(User)req.getSession().getAttribute("user");
        return user;
    }

    @RequestMapping("/quit")
    public void quit(HttpServletRequest req,HttpServletResponse resp){
        req.getSession().removeAttribute("user");
    }
}
