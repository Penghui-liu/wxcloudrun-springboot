package com.tencent.wxcloudrun.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.tencent.wxcloudrun.service.InformService;
import com.tencent.wxcloudrun.service.QrCodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class InformServiceImpl implements InformService {

    private final RestTemplate restTemplate;


    @Override
    public String handleInform(JSONObject data) {
        if (data.containsKey("Event") && data.get("Event").equals("subscribe")){
            String fromUserName = data.getString("FromUserName");
            String toUserName = data.getString("ToUserName");

            JSONObject responseData = new JSONObject();
            responseData.put("ToUserName",fromUserName);
            responseData.put("FromUserName",toUserName);
            responseData.put("CreateTime",System.currentTimeMillis()/1000);
            responseData.put("MsgType","text");
            responseData.put("Content","我的服务端接收到的您的关注通知，感谢您的关注，让我想想赠送您什么权益比较好呢。。。");
            return responseData.toJSONString();
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis()/1000);
    }
}
