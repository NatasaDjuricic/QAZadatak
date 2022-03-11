package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public @FindBy (id = "username")
    WebElement username;

    public @FindBy (id = "password")
    WebElement password;

    public @FindBy (css = ".button.button--primary")
    WebElement loginButton;


    //-------------------------------------------------

    public void inputUsername (String uname) {
        username.clear();
        username.sendKeys(uname);
    }

    public void inputPassword (String pass) {
        password.clear();
        password.sendKeys(pass);

    }

    public  void clickOnLoginButton (){
        loginButton.click();
    }

    }










