package com.lagou.utils;


import org.apache.commons.codec.digest.DigestUtils;

import java.util.UUID;

public class Md5 {

    public final static  String md5key = "lagou";
    /**
     * MD5方法
     * @param text 明文  123456
     * @param key 密钥   lagou
     * @return 密文
     * @throws Exception
     */
    public static String md5(String text, String key) throws Exception {
        //加密后的字符串
        String encodeStr= DigestUtils.md5Hex(text+key);
        //System.out.println("MD5加密后的字符串为:encodeStr="+encodeStr);
        return encodeStr;
    }

    /**
     * MD5验证方法
     * @param text 明文
     * @param key 密钥
     * @param md5 密文
     * @return true/false
     * @throws Exception
     */
    public static boolean verify(String text, String key, String md5) throws Exception {
        //根据传入的密钥进行验证
        String md5Text = md5(text, key);
        if(md5Text.equalsIgnoreCase(md5))
            // System.out.println("MD5验证通过");
            return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        // 注册 用户名：tom 密码 123456
        // 添加用户的时候，要进行加密
        String lagou = Md5.md5("123456", "lagou");
        System.out.println(lagou);
        // 登陆 用户名 tom 123456 select * from user where username = tom and password = 123456
        // 1.根据用户名进行查询 f00485441dfb815c75a13f3c3389c0b9
        boolean verify = Md5.verify("123456", "lagou", "f00485441dfb815c75a13f3c3389c0b9");
        System.out.println(verify);
    }

}
