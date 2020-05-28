package com.example.eurekaclient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author CcQun
 * @Date 2020/5/28 12:52
 */
@RestController
public class ClientController {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello Spring Cloud";
    }
}
