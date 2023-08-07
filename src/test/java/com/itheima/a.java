package com.itheima;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a {
    public static void main(String[] args) {
        int[] arr = {2,4,3,6,2,3,8,8};
        HashMap hashMap = new HashMap();
        for(int i=0;i<arr.length;i++) {
            int count =0;
            if(hashMap.get(arr[i]) == null) {
                count=1;
            }
            else {
                count = (int)hashMap.get(arr[i]) + 1;
            }
            hashMap.put(arr[i], count);
        }
        hashMap.forEach((key,Value) -> {
            System.out.println(key + "出现了" + Value + "次");
        });
    }
}
