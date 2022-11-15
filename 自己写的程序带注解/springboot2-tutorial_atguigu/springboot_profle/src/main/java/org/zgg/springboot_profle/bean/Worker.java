package org.zgg.springboot_profle.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile(value = {"test","default"})
@Component
@ConfigurationProperties("person")
@Data
public class Worker implements Person{

    private String name;
    private Integer age;
}
