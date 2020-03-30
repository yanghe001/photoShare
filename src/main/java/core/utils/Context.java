package core.utils;

import java.util.ArrayList;
import java.util.List;

public class Context {

    //截取字符串
    public static List<String> splitString(String str,String split){
        List<String> stringList=new ArrayList<>();
        String[] strings = str.split(split);
        for(String s : strings){
            stringList.add(s);
        }
        return stringList;
    }

    //将集合转换成字符串
    public static String addSplitString(List<String> stringList,String split){
        String str="";
        for(int i=0;i<stringList.size();i++){
            if(i==0){
                str=stringList.get(i);
            }else{
                str=str+split+stringList.get(i);
            }
        }
        return str;
    }

    public static void main(String[] args) {
        List<String> list= new ArrayList<>();
        list.add("2000");
        list.add("2020");
        list.add("2008");
        System.out.println(addSplitString(list," "));
    }
}
