package iuh.edu.vn.javabased.component_1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SampleBean {

    @Value("${spring.security.user}")
    private String username;

    public void doFoo(){
        System.out.println(username);
    }
}
