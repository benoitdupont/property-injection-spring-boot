package lab.one;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Tries to run the SpringBootApplication, as a simple Spring Configuration
 * -> Doesn't find the resources injected, application.properties is not loaded
 * -> how to load them ? EnableAutoConfiguration doesn't work
 *
 * Caused by: java.lang.IllegalArgumentException: Could not resolve placeholder 'application.property' in value "${application.property}"
 * @author Benoit Dupont
 */
@SpringJUnitConfig(MyAppWithOneConfigFile.class)
@EnableAutoConfiguration
class MyAppWithOneConfigFileAsSpringConfigWithResourcesEnableAutoConfigurationTest {
    @Test
    void boot() {
    }
}