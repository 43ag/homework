package ru.otus.logic.pages;

import annotations.Path;
import org.openqa.selenium.WebDriver;
import pageobject.PageObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Properties;

public abstract class BasePage<T> extends PageObject {

    public static Properties properties = new Properties();

    public static void loadProperties() {
        try {
            properties.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BasePage(WebDriver driver) {
        super(driver);
    }

    private String getPath() {
        Path path = getClass().getAnnotation(Path.class);
        if (path != null) {
            return path.value();
        }
        return "";
    }

    public T open() {
        loadProperties();
        String baseUrl = (String) properties.get("baseUrl");
        driver.get(baseUrl + getPath());
        return (T) this;
    }
}
