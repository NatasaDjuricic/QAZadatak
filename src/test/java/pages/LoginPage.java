package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
