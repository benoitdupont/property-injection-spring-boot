package lab.two;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Tries to run the SpringBootApplication, as a simple Spring Configuration
 * -> Doens't find the resources injected, application.properties is not loaded
 *
 * @author Benoit Dupont
 */
@SpringJUnitConfig(MyAppWithTwoConfigFiles.class)
class MyAppWithTwoConfigFilesAsSpringConfigTest {
    @Test
    void boot() {
    }
}