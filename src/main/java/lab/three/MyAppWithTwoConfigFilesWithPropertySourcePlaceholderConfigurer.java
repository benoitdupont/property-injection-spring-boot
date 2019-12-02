package lab.three;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * A simple Spring Boot application, that tries to inject a property located in the application.properties file, and
 * another from the file another.properties.
 * <p>
 * Works, by adding a {@link PropertySourcesPlaceholderConfigurer} to add the another.properties file
 *
 * @author Benoit Dupont
 */
@SpringBootApplication
public class MyAppWithTwoConfigFilesWithPropertySourcePlaceholderConfigurer implements CommandLineRunner {
    @Value("${another.property}")
    private String anotherProperty;

    @Value("${application.property}")
    private String applicationProperty;

    @Override
    public void run(String... args) {
        System.out.println(applicationProperty);
        System.out.println(anotherProperty);
    }

    @Bean
    static PropertySourcesPlaceholderConfigurer configurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocations(new ClassPathResource("/another.properties"));

        return configurer;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyAppWithTwoConfigFilesWithPropertySourcePlaceholderConfigurer.class);
    }
}