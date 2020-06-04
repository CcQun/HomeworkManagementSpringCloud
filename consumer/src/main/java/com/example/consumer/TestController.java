package com.example.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author CcQun
 * @Date 2020/6/4 17:01
 */
@RestController
@RefreshScope
public class TestController {
    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping("/config")
    public String config(){
        System.out.println(appName);
        return appName;
    }
}
