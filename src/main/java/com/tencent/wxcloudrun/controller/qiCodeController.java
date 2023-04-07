package com.tencent.wxcloudrun.controller;

import com.alibaba.fastjson.JSONObject;
import com.tencent.wxcloudrun.service.QrCodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * counter控制器
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class qiCodeController {

  private final QrCodeService qrCodeService;

  @GetMapping(value = "/qr-code/{sceneStr}")
  JSONObject get(@PathVariable String sceneStr) {
    log.info("创建微信永久二维码，sceneStr：{}", sceneStr);
    return qrCodeService.generateQrCode(sceneStr);
  }

  
}