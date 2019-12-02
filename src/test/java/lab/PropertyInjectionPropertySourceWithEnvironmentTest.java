package lab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test the injection of properties, using the {@link PropertySource}, but now get them via the environment
 *
 * Fails
 *
 * @author Benoit Dupont
 */
@SpringJUnitConfig
@PropertySource({"/application.properties", "/another.properties"})
class PropertyInjectionPropertySourceWithEnvironmentTest {

    @Autowired
    private Environment environment;

    @Test
    void injectProperties() {
        assertThat(environment.getProperty("applicationProperty"))
                .isNotBlank()
                .isNotEqualTo("${application.property}")
                .isEqualTo("src/test/resources/application.properties");

        assertThat(environment.getProperty("anotherProperty"))
                .isNotBlank()
                .isNotEqualTo("${application.property}")
                .isEqualTo("src/test/resources/another.properties");
    }
}