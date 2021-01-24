package com.cloud.service.impl;

import com.cloud.dao.OrderDao;
import com.cloud.domain.Order;
import com.cloud.service.AccountService;
import com.cloud.service.OrderService;
import com.cloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    @Override
    public void create(Order order) {
        log.info("----->开始新建订单");
        orderDao.create(order);
        log.info("----->订单微服务开始调用库存,做扣减");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("----->订单微服务开始调用库存,做扣减end");
        log.info("----->订单微服务开始调用账户,做扣减");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----->订单微服务开始调用账户,做扣减end");
        log.info("----->修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("----->修改订单状态结束");
        log.info("----->下订单结束");
    }
}
