package com.itheima;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
//        for (String s : list) {
//            if("a".equals(s)) {
//                list.remove(s);
//            }
//        }
//        for(int i=0;i<list.size();i++) {
//            if("a".equals(list.get(i))) {
//                list.remove(list.get(i));
//            }
//        }

        Iterator iterator = list.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().equals("b")) {
                iterator.remove();
            }
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
