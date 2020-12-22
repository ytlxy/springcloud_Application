package com.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池:"+Thread.currentThread().getName()+" paymentInfo_OK,id: "+id+"\t";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_Timeout(Integer id){
        int time=3000;
        try{
            TimeUnit.MILLISECONDS.sleep(time);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池:"+Thread.currentThread().getName()+" paymentInfo_Timeout,id: "+id+"\t"+"耗时"+time+"毫秒";
    }
    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池:"+Thread.currentThread().getName()+" 系统繁忙或运行报错,请稍后再试,id: "+id+"!!!";
    }
}
