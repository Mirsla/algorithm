package com.alex;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * description:
 * author: chenshoujiang
 * date: 2020/1/14
 */
public class test {

    public static void main(String[] args) throws IOException {
        String url = "http://119.39.227.91:20110/oppf?method=ABILITY_10004414&openId=1&appId=501401&format=json&sign=85F432C52694D573206811326460477C946936F2835490067F365A744005A108&operId=1&RegionId=3&accessToken=58d238d7-45ff-4f02-bc94-6cd93c5fff2c&busiSerial=2016102011223320345443&version=1.0&timestamp=20200114162659";
        String connect = "{\"body\":{\"beneficiary\":\"15608072071\",\"beneficiaryProps\":{},\"benefitType\":\"SCORE_BENEFIT_CENTER\",\"fee\":100000,\"isSendSms\":\"0\",\"isSynRedis\":\"1\",\"orderId\":\"234234124\",\"productId\":\"01\",\"productName\":\"奇新科技对接测试\",\"retryRefTransId\":\"\",\"retryType\":\"0\",\"rights\":{},\"sceneDesc\":\"\",\"sender\":\"qixin\",\"touchType\":\"99\",\"triggerType\":\"05\"},\"head\":{\"principal\":\"Axxh01\",\"source\":\"baiShi\",\"timestamp\":\"20200114162659027\",\"token\":\"DE7B525D6D86C265F61D5B81B35EB5F8\",\"transId\":\"BS20200114162659027000000001\"}}";


        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(url);
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
        postMethod.setRequestEntity(new StringRequestEntity(connect,"application/json", "utf-8"));
        int statusCode = httpClient.executeMethod(postMethod);


        System.out.println(statusCode);
        String result = new String(postMethod.getResponseBodyAsString().getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
        System.out.println(result);
    }
}
