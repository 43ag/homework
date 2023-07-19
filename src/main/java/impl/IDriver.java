package impl;

import exceptions.DriverDoNotSupported;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.Config;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public interface IDriver {
    String REMOTE_URL = System.getProperty("webdriver.remote.url");

    WebDriver newDriver();

    default URL getRemoteUrl() {
        try {
            return new URL(REMOTE_URL);
        } catch (MalformedURLException e) {
            return null;
        }
    }

    default void downloadLocalWebDriver(DriverManagerType driverManagerType)
            throws DriverDoNotSupported {
        Config config = WebDriverManager.globalConfig();
        config.setAvoidBrowserDetection(true);

        String browserVersion = System.getProperty("browser.version", "");

        if (!browserVersion.isEmpty()) {
            switch (driverManagerType) {
                case CHROME:
                    config.setChromeDriverVersion(browserVersion);
                    break;
                case OPERA:
                    config.setOperaDriverVersion(browserVersion);
                    break;
                default:
                    throw new DriverDoNotSupported(driverManagerType);
            }
        }
        WebDriverManager.getInstance(driverManagerType).setup();
    }
}
