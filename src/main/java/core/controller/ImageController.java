package core.controller;

import com.alibaba.fastjson.JSONObject;
import core.dao.LoveDao;
import core.pojo.Image;
import core.pojo.User;
import core.results.CodeMsg;
import core.results.PageInfo;
import core.results.PageResult;
import core.service.ImageService;
import core.service.LoveService;
import core.service.SortService;
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
@RequestMapping("/image")
public class ImageController {

    @Autowired
    ImageService imageService;
    @Autowired
    LoveService loveService;
    @Autowired
    LoveDao loveDao;
    @Autowired
    SortService sortService;

    @Value("${diy.httpTop}")
    private String httpTop;

    @Value("${diy.currentPage}")
    private int currentPage;
    @Value("${diy.pageSize}")
    private int pageSize;
    @Value("${diy.imagesPath}")
    private  String imagesPath;

    /**
     * 上传图集
     * @param sort_name
     * @param user_name
     * @param files
     * @return
     */
    @RequestMapping(value = "/insertImage",method= RequestMethod.POST)
    public CodeMsg insertImage(String sort_name,String user_name, @RequestParam(name = "file") MultipartFile[] files ){
        List<String> imageType = Arrays.asList("jpg","jpeg", "png", "bmp", "gif");
        String imgTypeError="";
        String uploadFileError="";
        String insertMysqlError="";
        if(sort_name==null||sort_name.equals("")){ return CodeMsg.UPLOAD_ERROR.fillArgs("请选择类型！"); }
        if(files.length == 0){ return CodeMsg.UPLOAD_ERROR.fillArgs("上传文件能不能为空"); }
        for (MultipartFile multipartFile : files) {
            if(multipartFile.isEmpty()){
                return CodeMsg.UPLOAD_ERROR.fillArgs("上传文件能不能为空");
            }
            String originalFilename = multipartFile.getOriginalFilename();//获取文件名+后缀
            String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();  // 获取文件的后缀格式
            String newFileName = System.currentTimeMillis() +"."+fileSuffix;
            String newFolder=imagesPath+FileUntil.chinaToEnglish(sort_name)+"/"+newFileName;
            if(!imageType.contains(fileSuffix)){
                imgTypeError=imgTypeError+originalFilename+" ";
                break;
            }
            String path=FileUntil.createFolderAndUploadFile(multipartFile,newFolder);
            if(path.equals("")||path==null){
                uploadFileError=uploadFileError+originalFilename+" ";
                break;
            }
            Image image=new Image();
            image.setUrl(path);
            image.setSort_name(sort_name);
            image.setUser_name(user_name);
            int result=imageService.insertImage(image);
            if(result<1){
                insertMysqlError=insertMysqlError+originalFilename+" ";
            }
        }
        if(!imgTypeError.equals("")){ return CodeMsg.UPLOAD_ERROR.fillArgs("格式错误的文件:"+imgTypeError); }
        if(!uploadFileError.equals("")){return CodeMsg.UPLOAD_ERROR.fillArgs("上传失败的文件:"+uploadFileError);}
        if(!insertMysqlError.equals("")){return CodeMsg.UPLOAD_ERROR.fillArgs("插入数据库失败的文件:"+insertMysqlError);}
        return CodeMsg.SUCCESS;
    }


    //首页数据不需要登录
    /**
     * 获取首页图片集 按照点赞排行
     * @param req
     * @return
     */
    @RequestMapping(value = "/findAllImageByOrderCountDESCPage",method= RequestMethod.POST)
    public PageResult<Image> findAllImageByOrderCountDESCPage(HttpServletRequest req){
        PageInfo pageInfo=new PageInfo();
        pageInfo.setCurrentPage(currentPage);
        pageInfo.setPageSize(pageSize);
        PageResult<Image> pageResult=new PageResult<>();
        List<Image> images=imageService.findAllImageByOrderCountDESCPage(pageInfo);
        images=toolAdd(req,images);
        pageResult.setPageInfo(pageInfo);
        pageResult.setRow(images);
        return pageResult;
    }

    /**
     * 获取分类推荐封面 按照点赞排行
     * @param req
     * @return
     */
    @RequestMapping(value = "/findImageBySortNameCover",method= RequestMethod.POST)
    public List<Image> findImageBySortNameCover(HttpServletRequest req){
        List<Image> images=imageService.findImageBySortNameCover();
        toolAdd(req,images);
        return images;
    }

    /**
     *  获取每个分类图片集 按照点赞排行 首页使用
     * @param req
     * @param jsonParam sort_name 分类名
     * @return
     */
    @RequestMapping(value = "/findImageBySortNamePage",method= RequestMethod.POST)
    public  PageResult<Image> findImageBySortNamePage(HttpServletRequest req, @RequestBody JSONObject jsonParam ){
        String sort_name=jsonParam.get("sort_name").toString();
        PageInfo pageInfo=new PageInfo();
        pageInfo.setCurrentPage(currentPage);
        pageInfo.setPageSize(pageSize);
        PageResult<Image> pageResult=new PageResult<>();
        List<Image> images=imageService.findImageBySortNamePage(sort_name,pageInfo);
        images=toolAdd(req,images);
        pageResult.setPageInfo(pageInfo);
        pageResult.setRow(images);
        return pageResult;
    }

    /**
     * 获取用户每类图片的封面
     * @param req
     */
    @RequestMapping(value = "/findImageBySortNameAndUserNameCover",method= RequestMethod.POST)
    public List<Image> findImageBySortNameAndUserNameCover(HttpServletRequest req){
        User user=(User)req.getSession().getAttribute("user");
        List<Image> images=imageService.findImageBySortNameAndUserNameCover(user.getName());
        toolAdd(req,images);
        return images;
    }

    /**
     * 根据类型获取该用户图集
     * @param req
     * @param jsonParam
     * @return
     */
    @RequestMapping(value = "/findImageListBySortNameAndUserNamePage",method= RequestMethod.POST)
    public PageResult<Image> findImageListBySortNameAndUserNamePage(HttpServletRequest req,@RequestBody JSONObject jsonParam){
        User user=(User)req.getSession().getAttribute("user");
        String sort_name=jsonParam.get("sort_name").toString();
        PageInfo pageInfo=new PageInfo();
        pageInfo.setCurrentPage(currentPage);
        pageInfo.setPageSize(pageSize);
        PageResult<Image> pageResult=new PageResult<>();
        List<Image> images=imageService.findImageListBySortNameAndUserNamePage(sort_name,user.getName(),pageInfo);
        images=toolAdd(req,images);
        pageResult.setPageInfo(pageInfo);
        pageResult.setRow(images);
        return pageResult;
    }

    /**
     * 根据图片id删除图片
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteImageById",method= RequestMethod.POST)
    public CodeMsg deleteImageById(@RequestParam("id") int id){
        boolean flag=imageService.deleteImageById(id);
        return flag?CodeMsg.SUCCESS:CodeMsg.ERROR;
    }

    /**
     * 删除多个图片 根据ids
     * @param ids
     * @return
     */
    @RequestMapping(value = "/deleteManyImageByIds",method= RequestMethod.POST)
    public CodeMsg deleteManyImageByIds(@RequestBody List<Integer> ids){
        boolean flag=imageService.deleteManyImageByIds(ids);
        return flag?CodeMsg.SUCCESS:CodeMsg.ERROR;
    }

    /**
     * 查找所有图片 按点赞排行
     * @return
     */
    @RequestMapping(value = "/findAllImagePage",method = RequestMethod.POST)
    public PageResult<Image> findAllImagePage(){
        PageInfo pageInfo=new PageInfo();
        pageInfo.setCurrentPage(currentPage);
        pageInfo.setPageSize(pageSize);
        List<Image> images=imageService.findAllImagePage(pageInfo);
        images=toolAddHttpTop(images);
        PageResult<Image> pageResult=new PageResult<>();
        pageResult.setPageInfo(pageInfo);
        pageResult.setRow(images);
        return pageResult;
    }

    /**
     *  获取每个分类图片集 按照点赞排行 管理员使用
     * @param jsonParam sort_name 分类名
     * @return
     */
    @RequestMapping(value = "/findAdminImageBySortNamePage",method= RequestMethod.POST)
    public  PageResult<Image> findAdminImageBySortNamePage(@RequestBody JSONObject jsonParam ){
        String sort_name=jsonParam.get("sort_name").toString();
        PageInfo pageInfo=new PageInfo();
        pageInfo.setCurrentPage(currentPage);
        pageInfo.setPageSize(pageSize);
        PageResult<Image> pageResult=new PageResult<>();
        List<Image> images=imageService.findImageBySortNamePage(sort_name,pageInfo);
        images=toolAddHttpTop(images);
        pageResult.setPageInfo(pageInfo);
        pageResult.setRow(images);
        return pageResult;
    }


    /**
     * 工具类  处理地址头 用户点赞
     * @param req
     * @param images
     * @return
     */
    public List<Image> toolAdd(HttpServletRequest req,List<Image> images){
        List<Integer> integerList=new ArrayList<>();
        if(images.size()>0){
            boolean flag=false;
            if(req.getSession().getAttribute("user")!=null){
                flag=true;
                User user=(User)req.getSession().getAttribute("user");
                integerList=loveService.findLoveByName(user.getName());
            }
            for(Image image : images){
                if(flag){
                    if(integerList.contains(image.getId())){
                        image.setFlag(true);
                    }
                }
                String str=image.getUrl();
                image.setUrl(httpTop+str);
            }
            return images;
        }
        return null;
    }

    /**
     * 工具类  处理地址头
     * @param images
     * @return
     */
    public List<Image> toolAddHttpTop(List<Image> images){
        if(images.size()>0){
            for(Image image : images){
                String str=image.getUrl();
                image.setUrl(httpTop+str);
            }
            return images;
        }
       return null;
    }

}
