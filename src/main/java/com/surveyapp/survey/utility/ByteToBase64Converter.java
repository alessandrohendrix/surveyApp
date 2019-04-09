package com.surveyapp.survey.utility;

import java.util.Base64;

public class ByteToBase64Converter {

    public static String convertToBase64(byte[] src) {
        if(src == null) {
            return "";
        }
        return Base64.getEncoder().encodeToString(src);
    }

    public static byte[] convertToByte(String src) {
        try {
            return Base64.getDecoder().decode(src.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[]{};
    }
}