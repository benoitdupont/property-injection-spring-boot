package lab.one;

import lab.two.MyAppWithTwoConfigFiles;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Tries to run the SpringBootApplication, as a simple Spring Configuration
 * -> Doens't find the resources injected, application.properties is not loaded
 * -> Test property source does the trick
 * @author Benoit Dupont
 */
@SpringJUnitConfig(MyAppWithOneConfigFile.class)
@TestPropertySource("/application.properties")
class MyAppWithOneConfigFileAsSpringConfigWithResourcesTestPropertySourceTest {

//    @Autowired
//    private MyAppWithOneConfigFile app;
//
//    @Test
//    void boot() {
//        app.run();
//    }

    @Test
    void boot() {

    }
}