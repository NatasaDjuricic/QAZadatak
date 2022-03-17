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

    //ime na profilu
    public @FindBy (xpath = "/html/body/div/div/div/div/div/div[2]/h2")
    WebElement deletePageName;

    //avatar na profilu
    public @FindBy (xpath = "/html/body/div/div/div/div/div/div[2]/div/div/img")
    WebElement deletePageAvatar;

    //"Delete profile" dugme
    public @FindBy (xpath = "/html/body/div/div/div/div/div/div[2]/button[1]")
    WebElement deleteButton;

    //"Choose profile" dugme
    public @FindBy (xpath = "//*[@id=\"app\"]/div/div/header/div/button[2]")
    WebElement chooseProfileButton;

    //------------------------------------------------------------------------

    //metod za klikni na "Delete Profile" dugme
    public void clickOnDeleteProfileButton () {
        deleteButton.click();
    }

    //metod za klikni na "Choose Profile" dugme
    public void clickOnChooseProfileButton () {
        chooseProfileButton.click();
    }
}
