package com.otus.steps.commons;

import com.google.inject.Inject;
import com.otus.driversFactory.WebDriverFactory;
import com.otus.pages.BasePage;
import com.otus.pages.MainPage;
import com.otus.support.GuiceScoped;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Пусть;

public class CommonSteps {
    @Inject
    public GuiceScoped guiceScoped;


    @Пусть("Открываем браузер {string}")
    public void openBrowser(String browserName) {
        guiceScoped.browserName = browserName;
        guiceScoped.driver = new WebDriverFactory(guiceScoped).getDriver(browserName);
    }
}
