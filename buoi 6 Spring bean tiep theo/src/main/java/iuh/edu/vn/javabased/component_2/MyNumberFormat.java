package iuh.edu.vn.javabased.component_2;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MyNumberFormat implements NumberFormat {
    @Override
    public String format(double number) {
        return "Formating " + number;
    }
}
