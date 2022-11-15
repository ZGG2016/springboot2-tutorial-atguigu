package com.example.springboot_adminserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 启用
@EnableAdminServer
@SpringBootApplication
public class SpringbootAdminserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAdminserverApplication.class, args);
    }

}
