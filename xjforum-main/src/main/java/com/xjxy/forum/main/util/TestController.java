package com.xjxy.forum.main.util;

import com.xjforum.home.entity.City;
import com.xjforum.home.service.CityServiceImpl;
import com.xjxy.forum.main.AllApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: M丶Rock
 * \* Date: 2020/12/18
 * \* Time: 10:34
 * \
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = AllApplication.class)
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class TestController {
    @Before
    public void init() {
        System.out.println("开始测试-----------------");
    }



    @After
    public void after() {
        System.out.println("测试结束-----------------");
    }


}
