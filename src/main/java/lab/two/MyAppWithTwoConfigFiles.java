package lab.two;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 *  A simple Spring Boot application, that tries to inject a property located in the application.properties file, and
 *  another from the file another.properties.
 *
 *  Fails, because the file another.property is not loaded
 *
 * @author Benoit Dupont
 */
@SpringBootApplication
public class MyAppWithTwoConfigFiles implements CommandLineRunner{
    @Value("${application.property}")
    private String applicationProperty;

    // org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'myAppWithTwoConfigFiles': Injection of autowired dependencies failed; nested exception is java.lang.IllegalArgumentException:
    // Could not resolve placeholder 'another.property' in value "${another.property}"
    @Value("${another.property}")
    private String anotherProperty;

    @Override
    public void run(String... args) {
        System.out.println(applicationProperty);
        System.out.println(anotherProperty);
    }

    public static void main(String[] args) {
        SpringApplication.run(MyAppWithTwoConfigFiles.class);
    }
}