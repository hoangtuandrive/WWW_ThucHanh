package iuh.edu.vn.javabased.bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScans({
        @ComponentScan(basePackages = "iuh.edu.vn.javabased"),
})
public class AppConfig {
//    @Bean
//    public User createUser1(){
//        User user =new User("teo","123");
//        return user;
//    }
    @Bean
    public User createUser2(){
        User User =new User("met","321");
        return User;
    }
}
