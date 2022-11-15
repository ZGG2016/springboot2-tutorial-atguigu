package org.zgg.springboot_web_01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    // 测试thymeleaf
    @GetMapping("/test01")
    public String test01(Model model){

        // model中的数据会被放在请求域中 request.setAttribute("a",aa)
        model.addAttribute("msg","hello springboot");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }
}
