package core.controller;

import core.pojo.Image;
import core.pojo.Skill;
import core.results.CodeMsg;
import core.service.SkillService;
import core.utils.FileUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/skill")
@CrossOrigin(allowCredentials="true",allowedHeaders="*")
public class SkillController {
    @Autowired
    SkillService skillService;

    @Value("${diy.skillImgPath}")
    private  String skillImgPath;

     /**
     * 上传技巧
     * @param
     * @return
     */
    @RequestMapping(value = "/insertSkill",method = RequestMethod.POST)
    public CodeMsg insertSkill(@RequestParam(name = "file") MultipartFile file,String title,String skill_url){
        if(file.isEmpty()){ return CodeMsg.UPLOAD_ERROR.fillArgs("上传文件能不能为空"); }
        String originalFilename = file.getOriginalFilename();//获取文件名+后缀
        String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();  // 获取文件的后缀格式
        List<String> imageType = Arrays.asList("jpg","jpeg", "png", "bmp", "gif");
        if(!imageType.contains(fileSuffix)){
            CodeMsg.UPLOAD_ERROR.fillArgs("文件格式错误");
        }
        String newFileName = System.currentTimeMillis() +"."+fileSuffix;
        String newFolder=skillImgPath+newFileName;
        String path=FileUntil.createFolderAndUploadFile(file,newFolder);
        Skill skill=new Skill();
        skill.setTitle(title);
        skill.setImage_url(path);
        skill.setSkill_url(skill_url);
        return skillService.insertSkill(skill)?CodeMsg.SUCCESS:CodeMsg.ERROR;
    }

    /**
     * 删除上传技巧
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteSkillById",method = RequestMethod.POST)
    public  CodeMsg deleteSkillById(@RequestParam("id")int id){
        return skillService.deleteSkillById(id)?CodeMsg.SUCCESS:CodeMsg.ERROR;
    }


    /**
     * 获取技巧集合
     * @return
     */
    @RequestMapping(value = "/findAllSkill",method = RequestMethod.POST)
    public List<Skill> findAllSkill(){
        List<Skill> skills=skillService.findAllSkill();
        return toolAddHttpTop(skills);
    }

    /**
     * 更新技巧信息
     * @return
     */
    @RequestMapping(value = "/updateSkillById",method = RequestMethod.POST)
    public CodeMsg updateSkillById(@RequestParam(name = "file") MultipartFile file,Integer id,String title,String skill_url){
        Skill skill=new Skill();
        if(!file.isEmpty()){
            String originalFilename = file.getOriginalFilename();//获取文件名+后缀
            String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();  // 获取文件的后缀格式
            List<String> imageType = Arrays.asList("jpg","jpeg", "png", "bmp", "gif");
            if(!imageType.contains(fileSuffix)){
                CodeMsg.UPLOAD_ERROR.fillArgs("文件格式错误");
            }
            String newFileName = System.currentTimeMillis() +"."+fileSuffix;
            String newFolder=skillImgPath+newFileName;
            String path=FileUntil.createFolderAndUploadFile(file,newFolder);
            skill.setImage_url(path);
        }
        skill.setId(id);
        skill.setTitle(title);
        skill.setSkill_url(skill_url);
        return skillService.updateSkillById(skill)?CodeMsg.SUCCESS:CodeMsg.ERROR;
    }

    @Value("${diy.httpTop}")
    private String httpTop;

    /**
     * 工具类  处理地址头
     * @param skills
     * @return
     */
    public List<Skill> toolAddHttpTop(List<Skill> skills){
        if(skills.size()>0){
            for(Skill skill : skills){
                String str=skill.getImage_url();
                skill.setImage_url(httpTop+str);
            }
            return skills;
        }
        return null;
    }

}
