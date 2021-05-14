package com.yuier.gamemall.common;

import java.security.MessageDigest;

public class Md5Util {

    /**
     * 进行MD5加密算法
     *
     * @param str
     * @return
     */
    public static String EncoderByMd5(String str) {
        StringBuffer sb = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte b[] = md.digest();
            int i;
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
        } catch (Exception e) {
            return null;
            //          e.printStackTrace();
        }
        return sb.toString();
    }
    /*测试md5*/
    public static void main(String[] args) {
        try {
            System.out.println( Md5Util.EncoderByMd5("123"));
        } catch (Exception e) {
            //
        }
    }
}
