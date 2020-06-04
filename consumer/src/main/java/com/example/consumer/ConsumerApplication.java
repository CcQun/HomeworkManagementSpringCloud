package com.example.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableHystrix
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@RestController
@RefreshScope
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Autowired
    ProducerDao producerDao;

    @HystrixCommand(fallbackMethod = "getDefaultUser")
    @RequestMapping("/api/v1/demo/get")
    public String toProducer() {
        return producerDao.toProducer();
    }

    public String getDefaultUser(Integer id) {
        System.out.println("熔断，默认回调函数");
        return "熔断";
    }
}
