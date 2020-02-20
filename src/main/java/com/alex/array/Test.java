package com.alex.array;



import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * description:
 * author: chenshoujiang
 * date: 2020/1/14
 */
public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
//        java.lang.String s = "{\"retCode\":\"B004\",\"retMsg\":\"å½\\u0093å\\u0089\\u008Dsourceæ\\u0097\\u00A0æ\\u009D\\u0083è¯·æ±\\u0082è®¿é\\u0097®æ\\u009D\\u0083ç\\u009B\\u008Aç±»å\\u009E\\u008B:SCORE_BENEFIT_CENTER\",\"timestamp\":\"20200114150859193\",\"transId\":\"BS20200114150858899000000001\"}";
//        Gson gson = new Gson();
//        JsonObject returnData = new JsonParser().parse(s).getAsJsonObject();
////        gson.
////        String s3 = gson.fromJson(s, String.class);
//        String s1 = new String(s.getBytes("UTF-8"), "ISO-8859-1");
//        System.out.println(s1);
////        String s2 = new String(s3.getBytes("ISO-8859-1"), "UTF-8");
//        System.out.println(s2);

        String s = "ffas我的啊";
        String s1 = new String(s.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        System.out.println(s1);

        String s2 = new String(s1.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        System.out.println(s2);
    }
}
