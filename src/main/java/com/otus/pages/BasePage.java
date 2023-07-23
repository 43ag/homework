package com.otus.pages;

import com.google.inject.Inject;
import com.otus.annotations.Path;
import com.otus.support.GuiceScoped;
import com.otus.pageobject.PageObject;

import java.util.Properties;

public class BasePage<T> extends PageObject {
    @Inject
    public BasePage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    private String getPath() {
        Path path = getClass().getAnnotation(Path.class);
        if (path != null) {
            return path.value();
        }
        return "";
    }

    public T open() {
        String baseUrl = "https://otus.ru";
        driver.get(baseUrl + getPath());
        return (T) this;
    }
}
