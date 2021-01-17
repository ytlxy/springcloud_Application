package com.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cloud.entities.CommonResult;
import com.cloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class CircleBreakerController {
    public static final String SERVICE_URL="http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback")
    public CommonResult<Payment> fallback(@PathVariable("id")Long id){
        CommonResult<Payment> result=restTemplate.getForObject(SERVICE_URL+"paymentSQL"+id,CommonResult.class,id);
        if (id<=4){
            throw new IllegalArgumentException("IllegalAccessException,非法参数异常");
        }else if (result.getData()==null){
            throw new NullPointerException("NullPointerException,该id没有记录,空指针异常");
        }
        return result;
    }
}
