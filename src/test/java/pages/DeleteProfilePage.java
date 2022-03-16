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

    public @FindBy (xpath = "/html/body/div/div/div/div/div/div[2]/h2")
    WebElement deletePageName;

    public @FindBy (xpath = "/html/body/div/div/div/div/div/div[2]/div/div/img")
    WebElement deletePageAvatar;

    public @FindBy (css = "card__delete button.button--delete.button--small")
    WebElement deleteButton;
}
