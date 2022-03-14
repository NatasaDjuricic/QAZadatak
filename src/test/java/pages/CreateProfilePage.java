package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class CreateProfilePage extends BasePage {
    public CreateProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public @FindBy (id = "profile-name")
    WebElement profileName;

    public @FindBy (xpath = "//*[@id=\"app\"]/div/div/div/form/div[2]/div/div[5]/label")
   WebElement age;

    public @FindBy (id = "year")
    WebElement birthYear;

    public @FindBy (xpath = "//*[@id=\"app\"]/div/div/div/form/div[3]/div/div[6]/label/div/img")
    WebElement avatar;

    public @FindBy (xpath = "//*[@id=\"app\"]/div/div/div/form/div[3]/div/div[16]/label/div/img")
    WebElement avatar1;

  public @FindBy (xpath = "/html/body/div/div/div/div/form/button")
  WebElement createProfileButton;


    //------------------------------------------

    public void inputProfileName (String pname) {
        profileName.click();
        profileName.clear();
        profileName.sendKeys(pname);
    }

    public void clickOnAge() {
        age.click();
    }

    public void inputBirthYear (String year) {
        birthYear.click();
        birthYear.sendKeys(year);
    }

    public void clickOnAvatar(){
        avatar.click();
    }


    public void clickOnCreateProfileButton(){
        createProfileButton.click();
        }
}




