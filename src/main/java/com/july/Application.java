package com.july;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.TimeZone;

/**
 * Nacos测试项目
 * @author zqk
 * @since 2019/11/7
 */
@SpringCloudApplication
//如果调用外部接口时需要放开
//@EnableFeignClients(basePackages = "com.july.api.**.client")
//加载配置类使用，使@ConfigurationProperties注解的类生效
//@EnableConfigurationProperties
@EnableCaching
@MapperScan(value = "com.july.test.mapper")
public class Application {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(Application.class, args);
    }

}
