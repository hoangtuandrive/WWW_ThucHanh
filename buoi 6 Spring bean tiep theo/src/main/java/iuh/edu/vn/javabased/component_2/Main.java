package iuh.edu.vn.javabased.component_2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        MyNumberFormatService nf = ctx.getBean(MyNumberFormatService.class);
        nf.doFormating(100d);

        NumberFormat mnf = ctx.getBean(MyNumberFormat.class);
        nf.setNumberFormat(mnf);
        nf.doFormating(100d);

        AnotherFormater anotherFormater = ctx.getBean(AnotherFormater.class);
        nf.setNumberFormat(anotherFormater);
        nf.doFormating(100d);

    }
}