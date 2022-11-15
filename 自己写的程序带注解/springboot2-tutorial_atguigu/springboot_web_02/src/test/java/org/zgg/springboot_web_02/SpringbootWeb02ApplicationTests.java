package org.zgg.springboot_web_02;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.zgg.springboot_web_02.bean.User;
import org.zgg.springboot_web_02.mapper.UserMapper;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class SpringbootWeb02ApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_user", Long.class);
        log.info("记录数为：{}", aLong);

        // 数据源类型：class com.zaxxer.hikari.HikariDataSource
        // 数据源类型：class com.alibaba.druid.pool.DruidDataSource
        log.info("数据源类型：{}", dataSource.getClass());
    }

    @Test
    void testDUserMapper(){
        User user = userMapper.selectById(1L);
        log.info("用户为： {}", user);
    }

}
