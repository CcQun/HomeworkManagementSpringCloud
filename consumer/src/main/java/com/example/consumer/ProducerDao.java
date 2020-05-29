package com.example.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author CcQun
 * @Date 2020/5/29 12:31
 */
@FeignClient(value = "producer")
public interface ProducerDao {
    @RequestMapping("/producer/get")
    public String toProducer();
}
