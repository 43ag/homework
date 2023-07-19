package ru.otus.logic.pages;

import annotations.Path;
import org.openqa.selenium.WebDriver;

@Path("/catalog/courses/")
public class CoursesPage extends BasePage<CoursesPage> {
    public CoursesPage(WebDriver driver) {
        super(driver);
    }

}
