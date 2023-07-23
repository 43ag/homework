package com.otus.driversFactory;

import com.google.inject.Inject;
import com.otus.impl.ChromeWebDriver;
import com.otus.impl.OperaWebDriver;
import com.otus.exceptions.DriverDoNotSupported;
import com.otus.impl.FireFoxWebDriver;
import com.otus.support.GuiceScoped;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class WebDriverFactory implements WebDriverFactoryInt {
    public GuiceScoped guiceScoped;

    @Inject
    public WebDriverFactory(GuiceScoped guiceScoped) {
        this.guiceScoped = guiceScoped;
    }

    @Override
    public EventFiringWebDriver getDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                return new EventFiringWebDriver(new ChromeWebDriver().newDriver()) {
                };
            case "opera":
                return new EventFiringWebDriver(new OperaWebDriver().newDriver()) {
                };
            case "firefox":
                return new EventFiringWebDriver(new FireFoxWebDriver().newDriver()) {
                };
            default:
                try {
                    throw new DriverDoNotSupported(browserName);
                } catch (DriverDoNotSupported e) {
                    e.printStackTrace();
                    return null;
                }
        }
    }
}