package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.service.QrCodeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * counter控制器
 */
@RestController
@RequiredArgsConstructor
public class InformController {

  private final Logger logger;

  @PostMapping(value = "/inform")
  String post(@RequestBody JSONObject data) {
    logger.info("接收到微信消息推送：{}", data);
    return "";
  }
  
}