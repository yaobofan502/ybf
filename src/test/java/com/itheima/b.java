package com.itheima;

import java.util.HashMap;
import java.util.Map;

public class b {
    public static void main(String[] args) {
        int[] arr = {2,4,3,6,2,3,8,8};
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            if(hashMap.get(arr[i]) == null) {
                hashMap.put(arr[i], 1);
            }
            else {
                hashMap.put(arr[i],(int)hashMap.get(arr[i]) + 1);
            }
        }
        hashMap.forEach((key,Value) -> {
            System.out.println(key + "出现了" + Value + "次");
        });
        for(Object result : hashMap.keySet()) {
            System.out.println("数字" + result + "共出现了" + hashMap.get(result) + "次");
        }
        System.out.println(hashMap.size());
    }
}
