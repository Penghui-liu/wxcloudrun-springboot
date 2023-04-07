package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.service.QrCodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * counter控制器
 */
@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class InformController {

  @PostMapping(value = "/inform")
  String post(@RequestBody JSONObject data) {
    log.info("接收到微信消息推送：{}", data);
    return "";
  }
  
}