package com.cloud.dao;

import com.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PayMentDao {
    public int save(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
