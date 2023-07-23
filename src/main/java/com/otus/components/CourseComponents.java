package com.otus.components;

import com.google.inject.Inject;
import com.otus.helpers.StringHelper;
import com.otus.support.GuiceScoped;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CourseComponents extends AbsBaseComponents<CourseComponents> {
    public List<WebElement> lessons =
            driver.findElements(By.xpath("//div[contains(@class,'sc-1ftuaec-0 coFpkJ')]"));

    public List<WebElement> dates = driver.findElements(By.xpath("//span[contains(@class,'sc-12yergf-7 dPBnbE')]"));

    @Inject
    public CourseComponents(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public void findCourseByTitle(String title) {
        Optional<WebElement> element =
                lessons.stream()
                        .filter(
                                webElement -> {
                                    WebElement titleWebElement =
                                            webElement.findElement(By.xpath("//h5"));
                                    return titleWebElement.getText().equals(title);
                                })
                        .findFirst();

        Assertions.assertTrue(element.isPresent());
        element.get().click();
    }

    public void getCourseGreaterDate(String date) {
        if (dates.size() > 1) {
            LocalDate localDate = StringHelper.getDateFromString(date, "dd.MM.yyyy");

            List<WebElement> courseList =
                    dates.stream()
                            .filter(webElement -> webElement.getText().equals("В октябре"))
                            .filter(webElement -> {
                                LocalDate courseDate = getDateFromCourse(webElement);
                                if (courseDate.isEqual(localDate) || courseDate.isAfter(localDate)) {
                                    return true;
                                }
                                return false;
                            })
                            .collect(Collectors.toList());

            for (WebElement course : courseList) {
                String startDate = course.findElement(By.xpath("//span[contains(text(),'С')]")).getText();
                String nameCourse = course.findElement(By.xpath("//h5")).getText();

                System.out.println("Название курса - " + nameCourse);
                System.out.println("Время начала - " + startDate);
            }
        }
    }

    public LocalDate getDateFromCourse(WebElement webElement) {
        String date = webElement.findElement(By.xpath("//span[contains(text(),'С')]")).getText();
        if (date.endsWith("года")) {
            return StringHelper.getDateFromString(date, "С dd MMMM yyyy года");
        }
        return StringHelper.getDateFromString(date + " " + LocalDate.now().getYear(), "С dd MMMM yyyy");
    }
}
