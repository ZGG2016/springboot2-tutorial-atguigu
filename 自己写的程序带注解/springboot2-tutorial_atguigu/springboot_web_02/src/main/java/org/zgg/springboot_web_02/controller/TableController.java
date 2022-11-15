package org.zgg.springboot_web_02.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zgg.springboot_web_02.bean.User;
import org.zgg.springboot_web_02.exception.UserTooManyException;
import org.zgg.springboot_web_02.service.UserService;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;

    /**
     * 错误处理测试
     * 不带请求参数或者参数类型不对，显示 400, 有400.html就会先匹配它，没有的话就匹配4XX.html
     */
    @GetMapping("/basic_table2")
    public String basic_table2(){
        int b = 10/0;
        return "table/basic_table";
    }

    @GetMapping("/basic_table")
    public String basic_table(){

        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn", defaultValue = "1") Integer pn,  Model model){
//     List<User> users = Arrays.asList(new User("zhangsan", "123456"),
//                new User("lisi", "123444"),
//                new User("haha", "aaaaa"),
//                new User("hehe ", "aaddd"));
//        model.addAttribute("users",users);
//
//        if (users.size() > 3){
//            throw new UserTooManyException();
//        }

        // 从数据库读取数据
//        List<User> users = userService.list();
//        model.addAttribute("users",users);

        Page<User> page = new Page<>(pn,2);
        Page<User> userPage = userService.page(page, null);

        model.addAttribute("users",userPage);

        return "table/dynamic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                             RedirectAttributes ra){  // 删除后，还在当前页

        userService.removeById(id);
        ra.addAttribute("pn",pn);

        return "redirect:/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
}
