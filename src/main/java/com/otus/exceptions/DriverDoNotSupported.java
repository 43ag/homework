package com.otus.exceptions;

import io.github.bonigarcia.wdm.config.DriverManagerType;

public class DriverDoNotSupported extends Exception {
    public DriverDoNotSupported(DriverManagerType driverType) {
        super(String.format("Browser type %s not supported", driverType.getBrowserName()));
    }

    public DriverDoNotSupported(String browserName) {
        super(String.format("Browser type %s not supported", browserName));
    }
}
