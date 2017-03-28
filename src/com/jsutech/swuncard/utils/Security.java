package com.jsutech.swuncard.utils;

import java.util.UUID;

/**
 * Created by zyzz on 17-3-28.
 * 与安全相关的实用工具函数
 */
public final class Security {

    private static final String KEY_STR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
    private static final int NOT_A_NUM = Integer.MIN_VALUE;

    private static int count = 0;


    private static boolean isNaN(int num){
        return num == NOT_A_NUM;

    }

    private static int charAt(String input, int pos){
        if(pos >=0 && pos <= input.length() - 1){
            return input.charAt(pos);
        }
        return NOT_A_NUM;
    }


    public static String lyf(String input){
        String output = "";
        int chr1, chr2, chr3;
        int enc1, enc2, enc3, enc4;
        int i = 0;

        do{
            chr1 = charAt(input, i++);
            chr2 = charAt(input, i++);
            chr3 = charAt(input, i++);
            enc1 = (char) (chr1 >> 2);
            enc2 = (char) (((chr1 & 3) << 4) | (chr2 >> 4));
            enc3 = (char) (((chr2 & 15) << 2) | (chr3 >> 6));
            enc4 = (char) (chr3 & 63);
            if (isNaN(chr2)) {
                enc3 = enc4 = 64;
            } else {
                if (isNaN(chr3)) {
                    enc4 = 64;
                }
            }
            output = output + KEY_STR.charAt(enc1) + KEY_STR.charAt(enc2) + KEY_STR.charAt(enc3) + KEY_STR.charAt(enc4);


        }while (i < input.length());
        if (count < 4){
            count ++;
            output = lyf(output);
        }else {
            count = 0;
        }

        return output;
    }

    public static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String addSalt(String dish, String salt){
        byte[] result = new byte[dish.length() + salt.length()];

        return "";
    }

}
