package com.jsutech.swuncard;
import com.jsutech.swuncard.utils.Security;
/**
 * Created by zyzz on 17-3-28.
 *
 */
public class DevMain {
    public static void main(String[] args){
        System.out.println(Security.lyf("368395"));
        System.out.println(Security.lyf("368395"));
        System.out.println();
        System.out.println(Security.uuid().length());
    }
}
