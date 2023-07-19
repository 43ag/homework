package ru.otus.logic.pages;

import annotations.Path;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.util.List;

@Path("/")
public class MainPage extends BasePage<MainPage> {
    public MainPage(WebDriver driver) {
        super(driver);
    }
}
