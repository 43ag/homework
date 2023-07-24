package com.example.homework1;

import annotations.Driver;
import components.CourseComponents;
import components.CoursePageComponents;
import extensions.UiExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.otus.logic.pages.MainPage;

@ExtendWith(UiExtension.class)
public class CoursesTests {

    @Driver
    private WebDriver driver;

    @Test
    public void selectCourseByTitle() {
        new MainPage(driver)
                .open();
        WebElement course = new CourseComponents(driver).findCourseByTitle("Product Marketing Manager в IT");
        course.click();
        new CoursePageComponents(driver).checkTitle("Product Marketing Manager в IT");
    }

    @Test
    public void getMaxDateFromCourseTest() {
        new MainPage(driver)
                .open();
        CourseComponents courseComponent = new CourseComponents(driver);
        WebElement course = courseComponent.getCourseWithMaxDate();
        String title = course.getText();
        String date = title.substring((title.indexOf("С") + 4), (title.indexOf("м") - 3)).trim();
        course.click();
        new CoursePageComponents(driver).checkDate(date);
    }
}


