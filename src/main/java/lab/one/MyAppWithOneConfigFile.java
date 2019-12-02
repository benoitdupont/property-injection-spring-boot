package lab.one;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * A simple Spring Boot application, that inject a property located in the application.properties file
 *
 * The property is displayed correctly
 *
 * @author Benoit Dupont
 */
@SpringBootApplication
public class MyAppWithOneConfigFile implements CommandLineRunner {

    @Value("${application.property}")
    private String applicationProperty;

    @Override
    public void run(String... args) {
        System.out.println(applicationProperty);
    }

    @Bean
    String value(){
        return applicationProperty;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyAppWithOneConfigFile.class);
    }
}