package iuh.edu.vn.xmlbased.xml2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("xml2.xml");
        Person x = (Person) ctx.getBean("p1");
        System.out.println(x);


    }
}
