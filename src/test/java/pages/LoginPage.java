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

    //"Username" polje
    public @FindBy (id = "username")
    WebElement username;

    //"Password" polje
    public @FindBy (id = "password")
    WebElement password;

    //"LOGIN" dugme
    public @FindBy (css = ".button.button--primary")
    WebElement loginButton;


    //-------------------------------------------------

    //unesi korisnicko ime
    public void inputUsername (String uname) {
        username.clear(); //prvo obrisi ako vec ima neki unos u polju
        username.sendKeys(uname);
    }

    //unesi lozinku
    public void inputPassword (String pass) {
        password.clear();
        password.sendKeys(pass);

    }

    //klikni na "LOGIN" dugme
    public  void clickOnLoginButton (){
        loginButton.click();
    }

    }










