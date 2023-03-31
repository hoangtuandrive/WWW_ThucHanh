package iuh.edu.vn.xmlbased.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("autowire.xml");
//        Department d = ctx.getBean("dept1", Department.class);
        Department d = ctx.getBean("dept1", Department.class);

        System.out.println(d);
    }
}
