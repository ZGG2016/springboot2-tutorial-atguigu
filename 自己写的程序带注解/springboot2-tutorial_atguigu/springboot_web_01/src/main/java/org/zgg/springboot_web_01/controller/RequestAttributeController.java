package org.zgg.springboot_web_01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestAttributeController {

    // 获取请求域中的值
    @GetMapping("/goto")
    public String GotoSuccess(HttpServletRequest request) {
        request.setAttribute("msg", "成功了。。。。");
        request.setAttribute("code", 200);
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map<String, Object> successPage(@RequestAttribute("msg") String msg,
                                           @RequestAttribute("code") Integer code,
                                           HttpServletRequest request) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("msg_ann", msg);
        map.put("msg_req", request.getAttribute("msg"));
        map.put("code", code);
        return map;
    }

    @GetMapping("/params")
    public String testParam(Map<String,Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response){
        map.put("hello-map","world-map");
        model.addAttribute("hello-model","world-model");
        request.setAttribute("hello-request","world-request");

        Cookie cookie = new Cookie("c1","v1");
        response.addCookie(cookie);
        return "forward:/success2";
    }

    @ResponseBody
    @GetMapping("/success2")
    public Map<String, Object> successPage2(HttpServletRequest request) {

        Map<String,Object> map = new HashMap<>();
        Object helloMap = request.getAttribute("hello-map");
        Object helloModel = request.getAttribute("hello-model");
        Object helloRequest = request.getAttribute("hello-request");

        map.put("helloMap",helloMap);
        map.put("helloModel",helloModel);
        map.put("helloRequest",helloRequest);

        return map;
    }
}
