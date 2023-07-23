package com.otus.pages;

import com.google.inject.Inject;
import com.otus.annotations.Path;
import com.otus.helpers.StringHelper;
import com.otus.support.GuiceScoped;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Path("/")
public class MainPage extends BasePage<MainPage> {
    @Inject
    public MainPage(GuiceScoped guiceScoped) {
        super(guiceScoped);
        PageFactory.initElements(driver, this);
    }
}