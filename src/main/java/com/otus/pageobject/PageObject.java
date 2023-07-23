package com.otus.pageobject;

import com.google.inject.Inject;
import com.otus.support.GuiceScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject<T> {
    protected WebDriver driver;

    @Inject
    public PageObject(GuiceScoped guiceScoped) {
        this.driver = guiceScoped.driver;
        PageFactory.initElements(driver, this);
    }
}