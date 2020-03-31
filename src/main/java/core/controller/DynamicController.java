package core.controller;

import com.alibaba.fastjson.JSONObject;
import core.pojo.Dynamic;
import core.pojo.DynamicComment;
import core.pojo.DynamicReply;
import core.pojo.User;
import core.results.CodeMsg;
import core.results.PageInfo;
import core.results.PageResult;
import core.service.DynamicCommentService;
import core.service.DynamicLoveService;
import core.service.DynamicReplyService;
import core.service.DynamicService;
import core.utils.Context;
import core.utils.FileUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(allowCredentials="true",allowedHeaders="*")
@RequestMapping("/dynamic")
public class DynamicController {

    @Autowired
    DynamicService dynamicService;

    @Value("${diy.dynamicImgPath}")
    private String dynamicImgPath;

    /**
     * 插入动态
     * @param files
     * @param content
     * @param req
     * @return
     */
    @RequestMapping(value = "/insertDynamic",method = RequestMethod.POST)
    public CodeMsg insertDynamic(@RequestParam(name = "file") MultipartFile[] files ,@RequestParam String content , HttpServletRequest req){
        List<String> imageType = Arrays.asList("jpg","jpeg", "png", "bmp", "gif");
        String imgTypeError="";
        String uploadFileError="";
        List<String> imageUrls=new ArrayList<>();
        for (MultipartFile multipartFile : files) {
            String originalFilename = multipartFile.getOriginalFilename();//获取文件名+后缀
            String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();  // 获取文件的后缀格式
            String newFileName = System.currentTimeMillis() +"."+fileSuffix;
            String newFolder=dynamicImgPath+newFileName;
            if(!imageType.contains(fileSuffix)){
                imgTypeError=imgTypeError+originalFilename+" ";
                continue;
            }
            String path= FileUntil.createFolderAndUploadFile(multipartFile,newFolder);
            if(path.equals("")||path==null){
                uploadFileError=uploadFileError+originalFilename+" ";
                continue;
            }
            imageUrls.add(path);
        }
        if(!imgTypeError.equals("")){ return CodeMsg.UPLOAD_ERROR.fillArgs("格式错误的文件:"+imgTypeError); }
        if(!uploadFileError.equals("")){return CodeMsg.UPLOAD_ERROR.fillArgs("上传失败的文件:"+uploadFileError);}
        User user=(User)req.getSession().getAttribute("user");
        Dynamic dynamic =new Dynamic();
        dynamic.setUser_name(user.getName());
        dynamic.setImages(Context.addSplitString(imageUrls,","));
        dynamic.setContent(content);
        return dynamicService.insertDynamic(dynamic)? CodeMsg.SUCCESS: CodeMsg.ERROR;
    }

    /**
     * 删除动态
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteDynamicById",method = RequestMethod.POST)
    public CodeMsg deleteDynamicById(@RequestParam Integer id){
        return dynamicService.deleteDynamicById(id)? CodeMsg.SUCCESS: CodeMsg.ERROR;
    }

    /**
     * 查询个人动态
     * @param req
     * @param pageInfo
     * @return
     */
    @RequestMapping(value = "/findUserDynamic",method = RequestMethod.POST)
    public PageResult<Dynamic> findUserDynamic(HttpServletRequest req,  @ModelAttribute PageInfo pageInfo){
        System.out.println(pageInfo);
        User user=(User)req.getSession().getAttribute("user");
        List<Dynamic> dynamics=dynamicService.findDynamicByUserNamePage(user.getName(),pageInfo);
        if(dynamics!=null){
            for(Dynamic dynamic : dynamics){
                dynamic.setDynamicCommentList(commentsTool(dynamic.getId()));
            }
            PageResult<Dynamic> dynamicPageResult=new PageResult<>();
            dynamicPageResult.setPageInfo(pageInfo);
            dynamicPageResult.setRow(dynamics);
            return dynamicPageResult;
        }
        PageResult<Dynamic> dynamicPageResult=new PageResult<>();
        dynamicPageResult.setPageInfo(pageInfo);
        dynamicPageResult.setRow(dynamics);
        return dynamicPageResult;
    }

    /**
     * 查询所有动态
     * @param pageInfo
     * @return
     */
    @RequestMapping(value = "/findAllDynamic",method = RequestMethod.POST)
    public PageResult<Dynamic> findAllDynamic(HttpServletRequest req, @ModelAttribute PageInfo pageInfo){
        String user_name="";
        if(req.getSession().getAttribute("user")!=null){
            User user=(User)req.getSession().getAttribute("user");
            user_name=user.getName();
        }
        List<Dynamic> dynamics=dynamicService.findDynamicAllPage(user_name,pageInfo);
        for(Dynamic dynamic : dynamics){
            dynamic.setDynamicCommentList(commentsTool(dynamic.getId()));
        }
        PageResult<Dynamic> dynamicPageResult=new PageResult<>();
        dynamicPageResult.setPageInfo(pageInfo);
        dynamicPageResult.setRow(dynamics);
        return dynamicPageResult;
    }

    @Autowired
    DynamicLoveService dynamicLoveService;

    /**
     * 用户点赞
     * @param req
     * @param id
     * @return
     */
    @RequestMapping(value = "/addOrDelPrise",method = RequestMethod.POST)
    public CodeMsg addOrDelPraise(HttpServletRequest req,Integer id){
        if(req.getSession().getAttribute("user")!=null){
            User user=(User)req.getSession().getAttribute("user");
            return dynamicLoveService.addOrDelDynamicLove(user.getName(),id)? CodeMsg.SUCCESS: CodeMsg.ERROR;
        }else{
            return CodeMsg.NOT_LOGIN;
        }
    }



    @Autowired
    DynamicCommentService dynamicCommentService;
    @Autowired
    DynamicReplyService dynamicReplyService;

    /**
     * 添加评论
     * @param req
     * @return
     */
    @RequestMapping(value = "/insertComment",method = RequestMethod.POST)
    public CodeMsg insertComment(HttpServletRequest req, Integer id,String content){
        if(req.getSession().getAttribute("user")!=null){
            User user=(User)req.getSession().getAttribute("user");
            DynamicComment dynamicComment=new DynamicComment();
            dynamicComment.setDynamic_id(id);
            dynamicComment.setContent(content);
            dynamicComment.setFrom_user(user.getName());
            return dynamicCommentService.insertDynamicComment(dynamicComment)?CodeMsg.SUCCESS:CodeMsg.ERROR;
        }else{
            return CodeMsg.NOT_LOGIN;
        }
    }

    /**
     * 添加回复
     * @param
     * @return
     */
    @RequestMapping(value = "/insertReply",method = RequestMethod.POST)
    public CodeMsg insertReplay(HttpServletRequest req,Integer comment_id,Integer dynamic_id,Integer identify_id,String content,String to_user){
        if(req.getSession().getAttribute("user")!=null){
            User user=(User)req.getSession().getAttribute("user");
            DynamicReply dynamicReply=new DynamicReply();
            dynamicReply.setFrom_user(user.getName());
            dynamicReply.setComment_id(comment_id);
            dynamicReply.setDynamic_id(dynamic_id);
            dynamicReply.setReply_type(identify_id);
            dynamicReply.setContent(content);
            dynamicReply.setTo_user(to_user);
            return dynamicReplyService.insertDynamicReply(dynamicReply)?CodeMsg.SUCCESS:CodeMsg.ERROR;
        }else{
            return CodeMsg.NOT_LOGIN;
        }
    }



    //获取某条动态下的评论
    public List<DynamicComment> commentsTool(Integer dynamic_id){
        List<DynamicComment> dynamicComments=dynamicCommentService.findCommentByDynamicId(dynamic_id);
        if(dynamicComments.size()>0){
            for(DynamicComment dynamicComment : dynamicComments){
                List<DynamicReply> dynamicReplies=dynamicReplyService.findCommentDynamicReply(dynamicComment.getId(),dynamicComment.getDynamic_id());
                if(dynamicReplies.size()>0){
                    replysTool(dynamicReplies);
                    dynamicComment.setDynamicReplyList(dynamicReplies);
                }
            }
        }
        return dynamicComments;
    }

    //递归封装回复计算
    public List<DynamicReply> replysTool(List<DynamicReply> dynamicReplies){
        for(DynamicReply dynamicReply : dynamicReplies){
            List<DynamicReply> dynamicReplies1=dynamicReplyService.findReplyDynamicReply(dynamicReply.getId(),dynamicReply.getDynamic_id(),dynamicReply.getFrom_user());
            if(dynamicReplies.size()>0){
                replysTool(dynamicReplies1);
                dynamicReply.setDynamicReplyList(dynamicReplies1);
            }
        }
        return dynamicReplies;
    }
}
