package iuh.edu.vn.javabased.component_2;

import org.springframework.stereotype.Component;

@Component
public class AnotherFormater implements NumberFormat{
    @Override
    public String format(double number) {
        return "formating something "+number;
    }
}
