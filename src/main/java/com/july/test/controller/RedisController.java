package com.july.test.controller;

import com.july.test.util.RedisToolUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Resource
    private RedisToolUtils redisToolUtils;

    @PostMapping("/setRedis")
    public void testRedis(){
        //redisToolUtils.setRedisContent("testRedisContent","123456789");
        redisToolUtils.setRedisContent("name","zengqiankun",10000L);
    }

    @PostMapping("/getRedis")
    public void getRedis(){
        String value = redisToolUtils.getRedisContent("name");
        System.out.println("===> " + value);
    }

}
