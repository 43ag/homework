package components;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoursePageComponents extends AbsBaseComponents<CoursePageComponents>{
    public CoursePageComponents(WebDriver driver) {
        super(driver);
    }

    public WebElement courseTitle = driver.findElement(By.xpath("//h1"));

    public WebElement courseDate = driver.findElement(By.xpath("(//div[@id='rec313881712']/div/div/div/div)[8]"));

    public void checkTitle(String title) {
        String actualTitle = courseTitle.getText();
        Assertions.assertEquals(actualTitle, title, "Название курса не совпадает с выбранным");
    }

    public void checkDate(String date) {
        String actualDate = courseDate.getText();
        Assertions.assertTrue(actualDate.contains(date.substring(0, date.toCharArray().length - 1)));
    }
}
