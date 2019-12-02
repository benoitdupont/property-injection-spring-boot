package lab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test the injection of properties, using the {@link PropertySource}
 * <p>
 * Works with a {@link PropertySourcesPlaceholderConfigurer}, doesn't with the {@link PropertySource} annotation.
 *
 * I guess that as opposed to @TestPropertySource, it doesn't register automatically à {@link PropertySourcesPlaceholderConfigurer}
 *
 * @author Benoit Dupont
 */
@SpringJUnitConfig
//@PropertySource({"/application.properties", "/another.properties"})
class PropertyInjectionPropertySourceTest {
    @Value("${application.property}")
    private String applicationProperty;

    @Value("${another.property}")
    private String anotherProperty;

    @Test
    void injectProperties() {
        assertThat(applicationProperty)
                .isNotBlank()
                .isNotEqualTo("${application.property}")
                .isEqualTo("src/test/resources/application.properties");

        assertThat(anotherProperty)
                .isNotBlank()
                .isNotEqualTo("${another.property}")
                .isEqualTo("src/test/resources/another.properties");
    }

    @Configuration
    static class MyTestConfig {
        @Bean
        static PropertySourcesPlaceholderConfigurer configurer() {
            PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
            configurer.setLocations(new ClassPathResource("/another.properties"), new ClassPathResource("/application.properties"));

            return configurer;
        }
    }
}