package core.controller;

import core.pojo.Image;
import core.pojo.Love;
import core.pojo.User;
import core.results.CodeMsg;
import core.service.ImageService;
import core.service.LoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/love")
@CrossOrigin(allowCredentials="true",allowedHeaders="*")
public class LoveController {

    @Autowired
    LoveService loveService;
    @Autowired
    ImageService imageService;

    @Value("${diy.httpTop}")
    private String httpTop;
    /**
     * 点赞接口
     * @param req
     * @param love
     * @return
     */
    @RequestMapping("/giveALike")
    public CodeMsg giveALike(HttpServletRequest req,@ModelAttribute Love love){
        User user=(User)req.getSession().getAttribute("user");
        boolean flag=loveService.addOrDelLove(love,user.getName());
        return flag?CodeMsg.SUCCESS:CodeMsg.ERROR;
    }
    /**
     * 查找我喜欢的
     * @param req
     * @return
     */
    @RequestMapping("/iLike")
    public List<Image> findLove(HttpServletRequest req){
        User user=(User)req.getSession().getAttribute("user");
        return toolAddHttpTop(loveService.findLove(user.getName()));
    }

    /**
     * 工具类 拼接地址
     * @param images
     * @return
     */
    public List<Image> toolAddHttpTop(List<Image> images){
        if(images==null){
            return null;
        }else{
            for(Image image : images){
                String str=image.getUrl();
                image.setUrl(httpTop+str);
                image.setFlag(true);
            }
            return images;
        }
    }

}
