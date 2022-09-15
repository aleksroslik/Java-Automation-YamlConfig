import DataSourceConfig.AppProperties;
import DataSourceConfig.DriverHandler;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {

    private static Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected static WebDriver driver;
    private static AppProperties appProperties;
    protected static DriverHandler driverHandler;

    @BeforeAll
    static void setDriver() {
        appProperties = AppProperties.getInstance();
        driverHandler = new DriverHandler();
        driver = driverHandler.getDriver();
        logger.info("Driver started successfully");
        driver.get(System.getProperty("appUrl"));
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
        logger.debug("Driver closed");
    }
}
