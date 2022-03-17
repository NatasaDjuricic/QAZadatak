package pages;

import base.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ChooseProfilePage extends BasePage {

    public ChooseProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //"Create new profile" dugme
    public @FindBy (css = ".button.button--primary")
    WebElement createNewProfileButton;

    //napravljen profil
    public @FindBy (xpath = "//*[@id=\"app\"]/div/div/div[1]/div[2]/div/img")
    WebElement profileButton;


    //---------------------------------------------------

    //klikni na "Create new profile" dugme
    public void clickOnCreateNewProfileButton() {
        createNewProfileButton.click();
    }

    //klikni na napravljen profil
    public void clickOnProfileButton(){
        profileButton.click();
    }




}
