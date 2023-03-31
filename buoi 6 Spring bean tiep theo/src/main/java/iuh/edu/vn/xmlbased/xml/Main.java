package iuh.edu.vn.xmlbased.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("xml1.xml");
        Student st1 = ctx.getBean("st1", Student.class);

        System.out.println(st1);
    }

}