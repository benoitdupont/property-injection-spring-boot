package lab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test the injection of properties, using the {@link TestPropertySource}
 *
 * Works !
 *
 * @author Benoit Dupont
 */
@SpringJUnitConfig
@TestPropertySource({"/application.properties", "/another.properties"})
class PropertyInjectionTestPropertySourceTest {

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
}