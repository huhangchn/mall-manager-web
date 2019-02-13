package com.github.huhangchn.util;

import sun.misc.BASE64Decoder;

public class FileTransUtil {

    public static byte[] base64topng(String imageBase64) {
        byte[] b1 = null;
        BASE64Decoder decoder = new BASE64Decoder();
        try{
            if (imageBase64.contains("data:image/jpeg;base64,")) {
                b1 = decoder.decodeBuffer(imageBase64.replaceAll("data:image/jpeg;base64,", ""));
            } else {
                if (imageBase64.contains("data:image/png;base64,")) {
                    b1 = decoder.decodeBuffer(imageBase64.replaceAll("data:image/png;base64,", ""));
                } else {
                    b1 = decoder.decodeBuffer(imageBase64.replaceAll("data:image/jpg;base64,", ""));
                }
            }
            for (int i = 0; i < b1.length; ++i) {
                if (b1[i] < 0) {// 调整异常数据
                    b1[i] += 256;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return b1;
    }
}
