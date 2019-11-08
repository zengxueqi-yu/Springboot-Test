package com.july.test;

import com.july.Application;
import com.july.test.util.RedisToolUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisToolTest {

    @Resource
    private RedisToolUtils redisToolUtils;

    /**
     * @description 写入缓存
     * @param
     * @return
     * @author zqk
     * @since 2019/11/6
    */
    @Test
    public void setRedisContent(){
        redisToolUtils.setRedisContent("name","zengxueqi");
    }

}
