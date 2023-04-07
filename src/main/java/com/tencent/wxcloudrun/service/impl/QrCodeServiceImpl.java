package com.tencent.wxcloudrun.service.impl;

import com.alibaba.fastjson.JSONObject;
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
public class QrCodeServiceImpl implements QrCodeService {

    private final RestTemplate restTemplate;

    @Override
    public JSONObject generateQrCode(String sceneStr) {
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/qrcode/create";
        //请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject paramData = new JSONObject();
        paramData.put("action_name","QR_LIMIT_STR_SCENE");
        JSONObject actionInfo = new JSONObject();
        JSONObject scene = new JSONObject();
        scene.put("scene_str",sceneStr);
        actionInfo.put("scene",scene);
        paramData.put("action_info",actionInfo);

        log.info("参数----{}",paramData);
        //封装成一个请求对象
        HttpEntity<JSONObject> entity = new HttpEntity<>(paramData, headers);

        JSONObject data = restTemplate.postForObject(requestUrl,entity,JSONObject.class);
        log.info("返回----{}",data);
        return data;
    }
}
