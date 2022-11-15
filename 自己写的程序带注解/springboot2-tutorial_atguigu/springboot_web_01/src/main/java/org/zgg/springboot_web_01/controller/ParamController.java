package org.zgg.springboot_web_01.controller;

import org.springframework.web.bind.annotation.*;
import org.zgg.springboot_web_01.bean.Person;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@RestController
public class ParamController {

    // 把 PathVariable 中的id 赋给外面的uid
    @GetMapping("/car/variable/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") String uid,
                                     @PathVariable("username") String name){

        HashMap<String, Object> map = new HashMap<>();
        map.put("uid",uid);
        map.put("name",name);
        return map;
    }

    // 方法的形参也可以使用一个map集合表示
//    @GetMapping("/car/variable/{id}/owner/{username}")
//    public Map<String, Object> getCar(@PathVariable Map<String, String> pv) {
//
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("uid", pv.get("id"));
//        map.put("name", pv.get("username"));
//        map.put("pv", pv);
//        return map;
//    }

    // 获取请求头
    @GetMapping("/car/header/{id}/owner/{username}")
    public Map<String, Object> getCar(@RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> allHeader) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("user-agent", userAgent);
        map.put("all-header", allHeader);
        return map;
    }

    // 获取请求参数
    @GetMapping("/car/params")
    public Map<String, Object> getCar(@RequestParam("id") String id,
                                      @RequestParam("name") String name,
                                      @RequestParam Map<String, String> allParams) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("all-params", allParams);
        return map;
    }

    // 获取请求体
    @PostMapping("/save")
    public Map<String, Object> getCar(@RequestBody String content) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("content", content);
        return map;
    }

    // 测试矩阵变量
    // 1、语法： 请求路径：/cars/sell;low=34;brand=byd,audi,yd
    // 2、SpringBoot默认是禁用了矩阵变量的功能
    //      需要手动开启
    //      对于路径的处理，在WebMvcAutoConfiguration类的 configurePathMatch 方法中使用UrlPathHelper进行解析。
    //              removeSemicolonContent（移除分号内容）属性支持矩阵变量的
    // 3、矩阵变量必须有url路径变量才能被解析（因为在GetMapping使用了它{path} ）
    @GetMapping("/cars/{path}")
    public Map<String, Object> carsSell(@MatrixVariable("low") String low,
                                        @MatrixVariable("brand") String brand,
                                        @PathVariable("path") String path){
        HashMap<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);

        return map;
    }

    // 对于矩阵变量 /boss/1;age=20/2;age=10 情况
    @GetMapping("/boss/{bossid}/{empid}")
    public Map<String, Object> carsSell2(@MatrixVariable(value = "age", pathVar = "bossid") Integer  bossAge,
                                         @MatrixVariable(value = "age", pathVar = "empid") Integer empAge){
        HashMap<String, Object> map = new HashMap<>();
        map.put("boss-age", bossAge);
        map.put("emp-age", empAge);

        return map;
    }

    // 测试封装POJO
    @PostMapping("/saveuser")
    public Person saveUser(Person person){
        return person;
    }

}
