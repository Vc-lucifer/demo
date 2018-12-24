package com.idea.cms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Test {

        public static boolean isLockNessMonster(String s) {
            //
            return Pattern.matches("^(?!([A-Z]*|[a-z]*|[0-9]*|[!-/:-@\\[-`{-~]*|[A-Za-z]*|[A-Z0-9]*|[A-Z!-/:-@\\[-`{-~]*|[a-z0-9]*|[a-z!-/:-@\\[-`{-~]*|[0-9!-/:-@\\[-`{-~]*)$)[A-Za-z0-9!-/:-@\\[-`{-~]{8,32}$", s);
        }

    public static void main(String[] args) throws Exception {

          /*  System.out.println(isLockNessMonster("9To0To;'"));
            System.err.println("To90To;'".length());*/

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = "2018-12-21 19:03:00";
        Date date = new Date();
        long startTime = date.getTime();
        Date parse = format.parse(str);
        long endTime = parse.getTime();
        long midTime = (endTime - startTime) / 1000;
        while (midTime > 0) {
            midTime--;
            long hh = midTime / 60 / 60 % 60;
            long mm = midTime / 60 % 60;
            long ss = midTime % 60;
            System.out.println("<<<<<<<<<<倒计时" + hh + "小时" + mm + "分钟" + ss + "秒>>>>>>>>>>");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Runtime.getRuntime().exec("shutdown -s -t 120");
    }

}


