package com.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPost;

    @GetMapping("payment/zk")
    public String paymentzk(){
        return "stringcloud with zookeeper: "+serverPost+"\t"+ UUID.randomUUID().toString();
    }
}
