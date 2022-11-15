package org.zgg.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zgg.boot.bean.Car;

@Slf4j
@RestController
public class HelloController {

    @Autowired
    private Car car;

    @RequestMapping("/hello")
    public String handler01(){
        log.info("请求.............");
        return "hello, spring boot 2";
    }

    @RequestMapping("/car")
    public Car getCar(){
        return car;
    }
}
