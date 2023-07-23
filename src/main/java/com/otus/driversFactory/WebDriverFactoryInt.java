package com.otus.driversFactory;

import com.otus.exceptions.DriverDoNotSupported;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public interface WebDriverFactoryInt {
    EventFiringWebDriver getDriver(String browserName) throws DriverDoNotSupported;
}
