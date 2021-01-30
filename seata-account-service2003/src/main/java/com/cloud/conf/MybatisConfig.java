package com.cloud.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.cloud.dao"})
public class MybatisConfig {
}
