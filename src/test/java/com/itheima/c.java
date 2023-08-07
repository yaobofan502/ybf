package com.itheima;

import com.alibaba.fastjson.JSONObject;
import com.sun.scenario.effect.impl.prism.PrTexture;
import org.apache.commons.lang.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class c {
    public static void main(String[] args) {
        //int mouths[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        Scanner scanner = new Scanner(System.in);
        String birth = scanner.next();
        String[] split1 = birth.split("-");
        LocalDateTime nowTime = LocalDateTime.now();
        String dateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(nowTime);
        String[] split2 = dateTime.split("-");
        int count = 0; // 11 18  5 31
        for(int i=0;i<3;i++) {
            int pre = Integer.parseInt(split1[i]);
            int now = Integer.parseInt(split2[i]);
            int a=0,b=0,c=0,d=0;
            if(i == 0) {
                count += (now - pre) * 365;
            } else if(i == 1) {
                a=pre * 30;
                b=now * 30;
            } else if(i == 2) {
                c=pre;
                d=now;
            }

        }

        System.out.println(count);
    }
}
