package lab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test the injection of properties, using the {@link TestPropertySource}
 *
 * Fails, funny that as opposed to {@link PropertyInjectionTestPropertySourceTest} it's not in the {@link Environment}
 *
 * @author Benoit Dupont
 */
@SpringJUnitConfig
@TestPropertySource({"/application.properties", "/another.properties"})
class PropertyInjectionTestPropertySourceWithEnvironmentTest {
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