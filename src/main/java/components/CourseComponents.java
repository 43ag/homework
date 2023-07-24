package components;

import helpers.StringHelper;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class CourseComponents extends AbsBaseComponents<CourseComponents> {
    public List<WebElement> lessons =
            driver.findElements(By.xpath("//h5"));

    public List<WebElement> dates = driver.findElements(By.xpath("//h5/parent::div/following-sibling::div/span[1]"));

    public CourseComponents(WebDriver driver) {
        super(driver);
    }

    public WebElement findCourseByTitle(String title) {
        Optional<WebElement> element =
                lessons.stream()
                        .filter(
                                webElement -> {
                                    WebElement titleWebElement =
                                            webElement.findElement(By.xpath("//h5"));
                                    String text = titleWebElement.getText();
                                    return titleWebElement.getText().equals(title);
                                })
                        .findFirst();

        Assertions.assertTrue(element.isPresent());
        return element.get();
    }

    public WebElement getCourseWithMaxDate() {

        WebElement course = null;
        if (dates.size() > 1) {

            course =
                    dates.stream()
                            .filter((WebElement element) -> !element.getText().equals("Успеть!"))
                            .reduce(
                                    dates.get(0),
                                    (webElement1, webElement2) -> {
                                        LocalDate localDate1 = getDateFromCourse(webElement1);
                                        LocalDate localDate2 = getDateFromCourse(webElement2);

                                        if (localDate1.isAfter(localDate2)) {
                                            return webElement1;
                                        }
                                        return webElement2;
                                    });
        }

        return course;
    }

    public WebElement getTitleOfCourseByDate(WebElement courseDate) {
        Optional<WebElement> element =
                lessons.stream()
                .filter(
                        webElement -> {
                            WebElement titleWebElement =
                                    webElement.findElement(By.xpath("//h5/parent::div/following-sibling::div/span[1]"));
                            return titleWebElement.getText().equals(courseDate.getText());
                        })
                .findFirst();

        Assertions.assertTrue(element.isPresent());
        return element.get();
    }

    public LocalDate getDateFromCourse(WebElement webElement) {
        String date = webElement.findElement(By.xpath("//span[contains(text(),'С')]")).getText();
        if (date.endsWith("года")) {
            return StringHelper.getDateFromString(date, "С dd MMMM yyyy года");
        }
        return StringHelper.getDateFromString(date + " " + LocalDate.now().getYear(), "С dd MMMM yyyy");
    }
}
