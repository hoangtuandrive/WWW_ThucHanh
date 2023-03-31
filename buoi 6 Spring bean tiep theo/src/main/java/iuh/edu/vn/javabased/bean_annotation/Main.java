package iuh.edu.vn.javabased.bean_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =new AnnotationConfigApplicationContext(AppConfig.class);
        User us = context.getBean(User.class);
        System.out.println(us);
        float f=3.14f;
    }
}
