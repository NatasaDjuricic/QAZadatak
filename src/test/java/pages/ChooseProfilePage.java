package pages;

import base.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChooseProfilePage extends BasePage {

    public ChooseProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public @FindBy (css = ".button.button--primary")
    WebElement createNewProfileButton;

    public @FindBy (xpath = "//*[@id=\"app\"]/div/div/div[1]/div[2]/div/img")
    WebElement profileButton;

    //---------------------------------------------------

    public void clickOnCreateNewProfileButton() {
        createNewProfileButton.click();
    }

    public void clickOnProfileButton(){
        profileButton.click();
    }


}
