package org.zgg.boot;

import ch.qos.logback.core.db.DBHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.zgg.boot.bean.Pet;
import org.zgg.boot.bean.User;
import org.zgg.boot.config.MyConfig;

/**
 * 主程序类
 * @SpringBootApplication：这是一个SpringBoot应用
 */
// 默认是扫描org.zgg.boot下的组件，下面可以修改包扫描的范围
//@SpringBootApplication(scanBasePackages = "org.zgg")
@SpringBootApplication
public class MainTest {

    public static void main(String[] args) {
//        SpringApplication.run(MainTest.class, args);

        //1、返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainTest.class, args);
        //2、查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name:names){
            System.out.println(name);
        }

        // 3. 获取容器里面的组件
        // 配置类MyConfig里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
        // 从容器里取的都是tomcat-pet组件
//        Pet pet01= run.getBean("tomcat-pet", Pet.class);
//        Pet pet02= run.getBean("tomcat-pet", Pet.class);
//        System.out.println("======> " + (pet01 == pet02)); // true
//
//
//        MyConfig myConfig = run.getBean(MyConfig.class);
//        // org.zgg.boot.config.MyConfig$$EnhancerBySpringCGLIB$$efdb364e@77e80a5e
//        System.out.println(myConfig);
//
//        // 如果 @Configuration(proxyBeanMethods = true)代理对象 调用方法。
//        // SpringBoot总会检查这个组件是否在容器中，如果在，就从容器里取这个组件，否则就重新创建。
//        // 保持组件单实例
//        User user01 = myConfig.user01();
//        User user02 = myConfig.user01();
//        // 如果 @Configuration(proxyBeanMethods = false)代理对象 调用方法，就返回false
//        System.out.println("======> " + (user01 == user02)); // true
//
//        // 从容器里取这个组件
////        User user = run.getBean("user01",User.class);
////        Pet pet = run.getBean("tomcat-pet", Pet.class);
////        System.out.println("======> " + (user.getPet() == pet)); // true
//
//        System.out.println("=============================");
//        String[] users = run.getBeanNamesForType(User.class);
//        for (String user : users) {
//            /*
//                org.zgg.boot.bean.User  这个就是通过import添加的组件
//                user01                  这个是通过@bean添加的组件
//             */
//            System.out.println(user);
//        }
//        String[] pets = run.getBeanNamesForType(Pet.class);
//        for (String pet : pets) {
//            /*
//                org.zgg.boot.bean.Pet
//                tomcat-pet
//             */
//            System.out.println(pet);
//        }

        System.out.println("=============================");
        // 把 @Bean("tomcat-pet") 注释掉
//        System.out.println(run.containsBean("tomcat-pet")); // false
//        System.out.println(run.containsBean("user01")); // true

        // 把 @Bean("tomcat-pet") 注释掉后，添加 @ConditionalOnBean(name = "tomcat-pet") 注解，
        // 就是有tomcat-pet组件的时候，才添加user01组件
//        System.out.println(run.containsBean("tomcat-pet"));  // false
//        System.out.println(run.containsBean("user01")); // false  因为 user01 依赖 tomcat-pet

        // 把 @Bean("tomcat-pet") 注释掉后，添加 @ConditionalOnMissingBean(name = "tomcat-pet") 注解，
        // 就是没有tomcat-pet组件的时候，才添加user01组件
//        System.out.println(run.containsBean("tomcat-pet"));  // false
//        System.out.println(run.containsBean("user01")); // true

        // 使用 @ImportResource("classpath:bean1.xml") 注解，才会找到这个组件，否则输出false
//        System.out.println(run.containsBean("haha"));
//        System.out.println(run.containsBean("hehe"));


    }
}
