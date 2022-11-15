package org.zgg.springboot_web_02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("org.zgg.springboot_web_02.mapper")
@ServletComponentScan(basePackages = "org.zgg.springboot_web_02")
@SpringBootApplication
public class SpringbootWeb02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWeb02Application.class, args);
    }

}
