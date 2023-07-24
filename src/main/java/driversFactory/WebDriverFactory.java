package driversFactory;

import exceptions.DriverDoNotSupported;
import impl.ChromeWebDriver;
import impl.FireFoxWebDriver;
import impl.OperaWebDriver;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class WebDriverFactory implements WebDriverFactoryInt {
    public static Properties properties = new Properties();

    public static void loadProperties() {
        try {
            properties.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private DriverManagerType getBrowserType() {
        loadProperties();
        String browserTypeProperty = properties.getProperty("browser").toUpperCase(Locale.ROOT);
        return DriverManagerType.valueOf(browserTypeProperty);
    }

    @Override
    public EventFiringWebDriver getDriver() {
        DriverManagerType browserType = getBrowserType();
        switch (browserType) {
            case CHROME:
                return new EventFiringWebDriver(new ChromeWebDriver().newDriver()) {
                };
            case OPERA:
                return new EventFiringWebDriver(new OperaWebDriver().newDriver()) {
                };
            case FIREFOX:
                return new EventFiringWebDriver(new FireFoxWebDriver().newDriver()) {
                };
            default:
                try {
                    throw new DriverDoNotSupported(browserType);
                } catch (DriverDoNotSupported e) {
                    e.printStackTrace();
                    return null;
                }
        }
    }
}