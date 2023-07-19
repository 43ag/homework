package com.example.homework1;

import annotations.Driver;
import components.CourseComponents;
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
    public void test1() {
        new MainPage(driver)
                .open();
        CourseComponents courseComponent = new CourseComponents(driver);
        WebElement course = courseComponent.findCourseByTitle("Цифровизация и трансформация бизнеса");
        course.click();
    }

    @Test
    public void getMaxDateFromCourseTest() {
        new MainPage(driver)
                .open();
        CourseComponents courseComponent = new CourseComponents(driver);
        WebElement course = courseComponent.getCourseWithMaxDate();
        course.click();
    }
}


