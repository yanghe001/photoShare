package core.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Util {
    //加密规则
    private static final String salt="1a2b3c4d";
    //MD5加密
    public static String md5(String str){
        return DigestUtils.md5Hex(str);
    }
    //加密规则+MD5加密
    public static String saltAndMd5(String inputPass){
        String str=salt.charAt(0)+salt.charAt(2)+inputPass+salt.charAt(4)+salt.charAt(5);
        return md5(str);
    }

    public static void main(String[] args) {
        System.out.println(saltAndMd5("1"));
    }
}
