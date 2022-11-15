package org.zgg.springboot_web_02.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zgg.springboot_web_02.bean.Account;
import org.zgg.springboot_web_02.bean.City;
import org.zgg.springboot_web_02.bean.User;
import org.zgg.springboot_web_02.service.AccountService;
import org.zgg.springboot_web_02.service.CityService;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountService accountService;

    @Autowired
    CityService cityService;

    // 去登录页
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){

        if (!StringUtils.isEmpty(user.getUserName()) && "111".equals(user.getPassword())){
            session.setAttribute("loginUser",user);
            // 登录成功就重定向到main.html，重定向是为了防止表单重复提交
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","账号密码错误");
            // 回到登录页面
            return "login";
        }
    }

    // 去main页面
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model){

        log.info("当前方法是：{}", "mainPage");

//        Object loginUser = session.getAttribute("loginUser");
//        // 判断是否已登录  拦截器，过滤器
//        if (loginUser!=null){
//            return "main";
//        }else{
//            model.addAttribute("msg","请重新登录");
//            // 回到登录页面
//            return "login";
//        }
        return "main";
    }

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_user", Long.class);
        return aLong.toString();
    }

    @ResponseBody
    @GetMapping("/acct")
    public Account getByUsername(@RequestParam("username") String username){
        return accountService.getAcctByname(username);
    }

    @ResponseBody
    @GetMapping("/city")
    public City getByUsername(@RequestParam("id") Integer id){
        return cityService.getCityById(id);
    }

    @ResponseBody
    @PostMapping("/city")
    public City saveCity(City city){
        cityService.insert(city);
        return city;
    }
}
