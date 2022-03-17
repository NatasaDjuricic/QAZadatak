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

    //"Name" polje
    public @FindBy (id = "profile-name")
    WebElement profileName;

    //18+
    public @FindBy (xpath = "//*[@id=\"app\"]/div/div/div/form/div[2]/div/div[5]/label")
   WebElement age;

    //"Enter your birth year" polje
    public @FindBy (id = "year")
    WebElement birthYear;

    //avatar
    public @FindBy (xpath = "//*[@id=\"app\"]/div/div/div/form/div[3]/div/div[6]/label/div/img")
    WebElement avatar;

    //"Create profile" dugme
    public @FindBy (xpath = "/html/body/div/div/div/div/form/button")
    WebElement createProfileButton;


    //------------------------------------------

    //unesi ime
    public void inputProfileName (String pname) {
        profileName.click(); //klikni na polje
        profileName.clear(); //obrisi prethodni unos
        profileName.sendKeys(pname); //unesi ime
    }

    //klikni na 18+
    public void clickOnAge() {
        age.click();
    }

    //unesi godinu rodjenja
    public void inputBirthYear (String year) {
        birthYear.click(); //klikni na polje
        birthYear.sendKeys(year); //unesi godinu rodjenja
    }

    //klikni na avatar
    public void clickOnAvatar(){
        avatar.click();
    }


    //klikni na "Create profile" dugme
    public void clickOnCreateProfileButton(){
        createProfileButton.click();
        }
}




