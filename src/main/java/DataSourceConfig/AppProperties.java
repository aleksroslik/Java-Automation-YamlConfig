package DataSourceConfig;

import Models.Browser;
import Models.EnvironmentSpecs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class AppProperties {

    static Logger logger = LoggerFactory.getLogger(AppProperties.class);
    YamlReader yamlReader = new YamlReader();
    private Browser browser;
    private List<EnvironmentSpecs> listOfEnvironments;

    public AppProperties() {
        setBrowserProperties();
        setEnvironmentProperties();
    }

    public static AppProperties getInstance() {
        return AppProperties.AppPropertiesSingleton.INSTANCE;
    }

    private void setEnvironmentProperties() {
        listOfEnvironments = yamlReader.getConfig().getEnvironment().getListOfEnvironments();
        boolean findActiveEnvironment = false;
        for (EnvironmentSpecs environmentSpecs : listOfEnvironments) {
            if (environmentSpecs.isActive()) {
                findActiveEnvironment = true;
                Map<String, Object> environmentProperties = environmentSpecs.getProperties();
                for (Map.Entry entry : environmentProperties.entrySet()) {
                    System.setProperty(entry.getKey().toString(), entry.getValue().toString());
                    logger.info("Loaded environment properties: {} = {}", entry.getKey().toString(), entry.getValue().toString());
                }
                break;
            }
        }
    }

    private void setBrowserProperties() {
        browser = yamlReader.getConfig().getBrowser();
        Map<String, Object> browserProperties = browser.getBrowserProperties();
        for (Map.Entry entry : browserProperties.entrySet()) {
            System.setProperty(entry.getKey().toString(), entry.getValue().toString());
            logger.info("Loaded browser properties: {} = {}", entry.getKey().toString(), entry.getValue().toString());
        }
    }

    private static class AppPropertiesSingleton {
        private static final AppProperties INSTANCE = new AppProperties();
    }
}
