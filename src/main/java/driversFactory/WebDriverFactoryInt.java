package driversFactory;

import exceptions.DriverDoNotSupported;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public interface WebDriverFactoryInt {
    EventFiringWebDriver getDriver() throws DriverDoNotSupported;
}
