package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.service.QrCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * counter控制器
 */
@RestController
@RequiredArgsConstructor
public class qiCodeController {

  private final QrCodeService qrCodeService;

  
}