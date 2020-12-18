package com.cloud.service.impl;

import com.cloud.dao.PayMentDao;
import com.cloud.entities.Payment;
import com.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PayMentDao payMentDao;

    public int save(Payment payment){
        return payMentDao.save(payment);
    }

    public Payment getPaymentById(Long id){
        return payMentDao.getPaymentById(id);
    }
}
