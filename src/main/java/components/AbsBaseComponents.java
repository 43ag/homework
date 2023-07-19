package components;

import org.openqa.selenium.WebDriver;
import pageobject.PageObject;

public abstract class AbsBaseComponents<C extends AbsBaseComponents> extends PageObject<AbsBaseComponents<AbsBaseComponents>> {
    public AbsBaseComponents(WebDriver driver) {
        super(driver);
    }
}
