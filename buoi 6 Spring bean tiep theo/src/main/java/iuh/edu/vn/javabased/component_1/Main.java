package iuh.edu.vn.javabased.component_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx =new AnnotationConfigApplicationContext(AppConfig.class);
        SampleBean myBean = ctx.getBean(SampleBean.class);
        myBean.doFoo();
    }
}
