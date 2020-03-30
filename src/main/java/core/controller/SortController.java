package core.controller;

import core.pojo.Sort;
import core.results.CodeMsg;
import core.service.SortService;
import core.utils.FileUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(allowCredentials="true",allowedHeaders="*")
@RequestMapping("/sort")
public class SortController {

    @Autowired
    SortService sortService;

    /**
     * 插入类别
     * @param sort_name
     * @return
     */
    @RequestMapping(value = "/insertSort",method= RequestMethod.POST)
    public CodeMsg insertSort(@RequestParam("sort_name")String sort_name){
        if(sort_name.equals("")||sort_name==null){
            return CodeMsg.SORT_ERROR.fillArgs("分类名不能为空");
        }
        int result= sortService.insertSort(sort_name);
        return result>0?CodeMsg.SUCCESS:CodeMsg.ERROR;
    }

    /**
     * 删除类别
     * @param sort_name
     * @return
     */
    @RequestMapping(value = "/deleteSortByName",method= RequestMethod.POST)
    public CodeMsg deleteSortByName(@RequestParam("sort_name")String sort_name){
        String str= FileUntil.chinaToEnglish(sort_name);
        return  sortService.deleteSortByName(str)?CodeMsg.SUCCESS:CodeMsg.ERROR;
    }

    /**
     * 查找所有类别
     * @return
     */
    @RequestMapping(value = "/findAllSort" ,method= RequestMethod.POST)
    public List<Sort> findAllSort(){
        return sortService.findAllSort();
    }
}
