package lab.one;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Tries to run the SpringBootApplication, as a simple Spring Configuration
 * -> Doesn't find the resources injected, application.properties is not loaded
 *
 * Caused by: java.lang.IllegalArgumentException: Could not resolve placeholder 'application.property' in value "${application.property}"
 *
 * I guess that the {@link MyAppWithOneConfigFile} is loaded as a {@link org.springframework.context.annotation.Configuration}, but the autoconfiguration
 * is not executed.
 *
 * @author Benoit Dupont
 */
@SpringJUnitConfig(MyAppWithOneConfigFile.class)
class MyAppWithOneConfigFileAsSpringConfigTest {
    @Test
    void boot() {
    }
}