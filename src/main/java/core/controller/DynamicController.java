package core.controller;

import core.pojo.Dynamic;
import core.pojo.User;
import core.results.CodeMsg;
import core.results.PageInfo;
import core.results.PageResult;
import core.service.DynamicLoveService;
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
@RequestMapping("/aa")
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
    public CodeMsg insertDynamic(@RequestParam(name = "file") MultipartFile[] files , String content , HttpServletRequest req){
        List<String> imageType = Arrays.asList("jpg","jpeg", "png", "bmp", "gif");
        String imgTypeError="";
        String uploadFileError="";
        List<String> imageUrls=new ArrayList<>();
        if(files.length == 0){ return CodeMsg.UPLOAD_ERROR.fillArgs("上传文件能不能为空"); }
        for (MultipartFile multipartFile : files) {
            if (multipartFile.isEmpty()) {
                return CodeMsg.UPLOAD_ERROR.fillArgs("上传文件能不能为空");
            }
            String originalFilename = multipartFile.getOriginalFilename();//获取文件名+后缀
            String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();  // 获取文件的后缀格式
            String newFileName = System.currentTimeMillis() +"."+fileSuffix;
            String newFolder=dynamicImgPath+newFileName;
            if(!imageType.contains(fileSuffix)){
                imgTypeError=imgTypeError+originalFilename+" ";
                break;
            }
            String path= FileUntil.createFolderAndUploadFile(multipartFile,newFolder);
            if(path.equals("")||path==null){
                uploadFileError=uploadFileError+originalFilename+" ";
                imageUrls.add(path);
                break;
            }
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
    public PageResult<Dynamic> findUserDynamic(HttpServletRequest req, PageInfo pageInfo){
        User user=(User)req.getSession().getAttribute("user");
        List<Dynamic> dynamics=dynamicService.findDynamicByUserNamePage(user.getName(),pageInfo);
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
    public PageResult<Dynamic> findAllDynamic(HttpServletRequest req, PageInfo pageInfo){
        String user_name="";
        if(req.getSession().getAttribute("user")!=null){
            User user=(User)req.getSession().getAttribute("user");
            user_name=user.getName();
        }
        List<Dynamic> dynamics=dynamicService.findDynamicAllPage(user_name,pageInfo);
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
    public CodeMsg addOrDelPraise(HttpServletRequest req, Integer id){
        if(req.getSession().getAttribute("user")!=null){
            User user=(User)req.getSession().getAttribute("user");
            return dynamicLoveService.addOrDelDynamicLove(user.getName(),id)? CodeMsg.SUCCESS: CodeMsg.ERROR;
        }else{
            return CodeMsg.NOT_LOGIN;
        }
    }
}
