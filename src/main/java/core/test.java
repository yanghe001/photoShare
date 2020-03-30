package core;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class test {
    public static void main(String[] args) {
        List<String> a=new ArrayList<>();
        List<String> b=new ArrayList<>();
        a.add("A");
        a.add("B");
        b.add("B");
        b.add("C");
        List<String> intersection = a.stream().filter(item -> b.contains(item)).collect(toList());
        intersection.forEach(s-> System.out.println(s));

    }

}
