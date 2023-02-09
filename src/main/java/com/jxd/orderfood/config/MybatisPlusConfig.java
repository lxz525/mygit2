package com.jxd.orderfood.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MybatisPlusConfig
 * @Description TODO
 * @Author lixianzhao
 * @Date 2023/1/28
 * @Version 1.0
 */
@Configuration
public class MybatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {
        //创建插件集合
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        //创建分页插件，并指定数据库类型
        PaginationInnerInterceptor paginationInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);
        //添加分页插件
        mybatisPlusInterceptor.addInnerInterceptor(paginationInterceptor);
        return mybatisPlusInterceptor;
    }
}
