package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public abstract class PageObject<T> {
    protected WebDriver driver;
    protected Actions action;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
}
