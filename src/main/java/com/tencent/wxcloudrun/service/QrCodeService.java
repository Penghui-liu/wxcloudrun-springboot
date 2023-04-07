package com.tencent.wxcloudrun.service;

import com.alibaba.fastjson.JSONObject;

public interface QrCodeService {
    JSONObject generateQrCode(String sceneStr);
}
