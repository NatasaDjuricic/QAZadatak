package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProfilePage extends BasePage {
    public DeleteProfilePage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public @FindBy (className = "card__avatar-outer")
    WebElement deletePageAvatar;

    public @FindBy (css = "card__delete button.button--delete.button--small")
    WebElement deleteButton;
}
