package org.zgg.springboot_profle.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zgg.springboot_profle.bean.Person;

@RestController
public class HelloController {

    @Value("${person.name: zhangsan}")
    private String name;

    @Autowired
    public Person person;

    @Value("${MAVEN_HOME}")
    private String msg;

    @GetMapping("/hello")
    public String hello(){
        return "hello " + name;
    }

    // profile分组测试
    @GetMapping("/hello2")
    public String hello2(){
        return person.getClass().getName();
    }

    // 外部化配置：环境变量
    @GetMapping("/msg")
    public String msg(){
        return msg;
    }
}
