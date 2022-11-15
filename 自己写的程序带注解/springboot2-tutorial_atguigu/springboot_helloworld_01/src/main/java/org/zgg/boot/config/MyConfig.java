package org.zgg.boot.config;

import ch.qos.logback.core.db.DBHelper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.zgg.boot.bean.Car;
import org.zgg.boot.bean.Pet;
import org.zgg.boot.bean.User;

/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理bean的方法
 * Full(proxyBeanMethods = true)、【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 * Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
 * 如果存在组件依赖必须使用Full模式默认。其他默认是否Lite模式
 * <p>
 * 4、@Import({User.class, DBHelper.class})
 * 给容器中自动创建出这两个类型的组件，默认组件的名字就是全类名 org.zgg.boot.bean.User
 * <p>
 * 5、@ImportResource("classpath:beans.xml")导入Spring的配置文件，
 */
@Import({User.class, Pet.class})
// 告诉SpringBoot这是一个配置类 == spring里的配置文件
@Configuration(proxyBeanMethods = true)
// 满足Conditional指定的条件，则进行组件注入
//@ConditionalOnBean(name = "tomcat-pet")
//@ConditionalOnMissingBean(name = "tomcat-pet")
// 导入Spring的配置文件
//@ImportResource("classpath:bean1.xml")
// 1、开启Car配置绑定功能  2、把这个Car这个组件自动注册到容器中
@EnableConfigurationProperties(Car.class)
public class MyConfig {

    /**
     * Full:外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     */
    // 给容器中添加组件。以方法名作为组件的id。返回类型就是组件类型。返回的值，就是组件在容器中的实例
    @Bean
    public User user01() {
        User zhangsan = new User("zhangsan", 18, pet01());
//        User zhangsan = new User("zhangsan", 18);
        return zhangsan;
    }

    //    @Bean("tomcat-pet")
    public Pet pet01() {
        return new Pet("tomcat");
    }

    //    @Bean
//    public CharacterEncodingFilter filter(){
//        return null;
//    }
}
