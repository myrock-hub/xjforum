package com.xjxy.forum.main;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: admin
 * \* Date: 2020/12/15
 * \* Time: 10:37
 * \
 */

@SpringBootApplication(scanBasePackages ="com.xjforum.home")
//扫描 main,test 模块中的下的所有包
//在 pom 加载子模块依赖才可以骚包
@ServletComponentScan(basePackages={"com.xjforum.*"})
@MapperScan(basePackages = "com.xjforum.*.mapper")
@EnableJpaRepositories("com.xjforum.home.dao")
@EntityScan("com.xjforum.home")
@ComponentScan({"com.xjxy.forum","com.xjforum.home","com.xjforum.admin"})
@EnableSwagger2
public class AllApplication {
    public static void main(String[] args) {
        //启动 Web 容器
        SpringApplication.run(AllApplication.class, args);
        System.out.println("[启动成功]"+new Date());
    }
}
