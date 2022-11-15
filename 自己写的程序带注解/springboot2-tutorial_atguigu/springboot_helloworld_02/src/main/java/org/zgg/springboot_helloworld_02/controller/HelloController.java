package org.zgg.springboot_helloworld_02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zgg.springboot_helloworld_02.bean.Person;

@RestController
public class HelloController {

    @Autowired
    private Person person;

    @RequestMapping("/person")
    public Person getPerson(){
        // 注意application.yml中username的变化及对应的输出
        // 单引号会将 \n 作为字符串输出; 双引号会将 \n 作为换行输出
        String userName = person.getUserName();
        System.out.println(userName);
        return person;
    }
}
