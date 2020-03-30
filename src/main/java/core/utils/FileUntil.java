package core.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class FileUntil {
    private static  String rootPath;

    static {
        try {
            rootPath = ResourceUtils.getURL("classpath:static/").getPath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String createFolderAndUploadFile(MultipartFile file,String newFolder){
        String rePath="";
        String path="";
        try {
            path = rootPath+newFolder;
            File destFile = new File(path);
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }
            file.transferTo(destFile);
            rePath=newFolder;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            rePath="";
        }
        return rePath;
    }
    public static String chinaToEnglish(String inputString){
        //将中文转换为英文
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        String output = "";
        if (inputString != null && inputString.length() > 0 && !"null".equals(inputString)) {
            char[] input = inputString.trim().toCharArray();
            try {
                for (int i = 0; i < input.length; i++) {
                    if (java.lang.Character.toString(input[i]).matches(
                            "[\\u4E00-\\u9FA5]+")) {
                        String[] temp = PinyinHelper.toHanyuPinyinStringArray(
                                input[i], format);
                        output += temp[0];
                    } else
                        output += java.lang.Character.toString(input[i]);
                }
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
        } else {
            return "*";
        }
        return output;
    }
    public static boolean deleteManyFile(List<String> list){
        boolean flag=false;
        if(list.size()>0){
           for(String str : list){
               String path=rootPath+str;
               File file=new File(path);
               if(file.exists()){
                   flag=file.delete();
               }
           }
        }else{
            flag=false;
        }
        return flag;
    }
    public static boolean deleteFolder(String delFolder){
        String pathFolder=rootPath+delFolder;
        File folder=new File(pathFolder);
        File[] files=folder.listFiles();
        if(files!=null){
            for (File f : files) {
                f.delete();
            }
        }
        return folder.delete();
    }
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(deleteFolder("donghua"));
    }
}
