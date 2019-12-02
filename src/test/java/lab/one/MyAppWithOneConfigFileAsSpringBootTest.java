package lab.one;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runs by default the SpringBootApplication
 * <p>
 * application.properties is loaded from src/test/resources and not src/main/resources, as file from test take precedence
 *
 * @author Benoit Dupont
 */
@SpringBootTest
class MyAppWithOneConfigFileAsSpringBootTest {

    @Autowired
    String value;

    @Test
    void boot() {
        assertThat(value).isEqualTo("src/test/resources/application.properties");
    }
}