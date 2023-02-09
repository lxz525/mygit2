package com.jxd.orderfood;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName OrderApplication
 * @Description TODO
 * @Author lixianzhao
 * @Date 2023/1/28
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.jxd.orderfood.dao")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class);
    }
}
