import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EnvironmentTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(EnvironmentTest.class);

    @Test
    @DisplayName("Check title")
    @Tag("regression")
    void checkTitle() {
        logger.info(">>>> Start test >>>>>");
        String actualTitle = driver.getTitle();
        logger.info("Actual title: {}", actualTitle);
        logger.info("Expected title: {}", System.getProperty("title"));
        assertThat(actualTitle).isEqualTo(System.getProperty("title"));
    }
}
