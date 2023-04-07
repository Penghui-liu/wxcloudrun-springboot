package com.tencent.wxcloudrun.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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