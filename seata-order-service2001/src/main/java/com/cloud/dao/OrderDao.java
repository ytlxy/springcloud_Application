package com.cloud.dao;

import com.cloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {
    void create(Order order);

    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
