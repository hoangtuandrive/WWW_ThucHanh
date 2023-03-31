package iuh.edu.vn.javabased.component_1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("iuh.edu.vn.javabased.component_1")
@PropertySource("classpath:component_1.properties")
public class AppConfig {
}
