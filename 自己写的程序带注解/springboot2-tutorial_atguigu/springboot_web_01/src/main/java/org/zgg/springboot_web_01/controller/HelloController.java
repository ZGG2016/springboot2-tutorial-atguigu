package org.zgg.springboot_web_01.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    // 如果静态目录下的资源名也是superset.png，那么访问 http://localhost:8080/superset.png ，会执行这个方法
    @RequestMapping("/superset.png")
    public String staticTest(){
        return "controller.......";
    }

    //    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping("/user")
    public String getUser(){

        return "GET-张三";
    }

    //    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    public String saveUser(){
        return "POST-张三";
    }


    //    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    @PutMapping("/user")
    public String putUser(){

        return "PUT-张三";
    }

    @DeleteMapping("/user")
//    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser(){
        return "DELETE-张三";
    }

}
