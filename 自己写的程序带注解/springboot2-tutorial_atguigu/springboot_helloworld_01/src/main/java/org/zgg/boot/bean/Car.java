package org.zgg.boot.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// 读取properties文件中的内容，并且把它封装到JavaBean中
//@Component
// 必须将Car添加到容器中，可以使用 @Component，也可以在配置类中添加 @EnableConfigurationProperties(Car.class)
@ConfigurationProperties(prefix = "mycar")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {
    private String brand;
    private Integer price;
}
