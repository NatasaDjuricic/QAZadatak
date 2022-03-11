package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestPage extends BasePage {
    @BeforeMethod
    public void setUpPage() {
        driver.manage().window().maximize();
        driver.navigate().to(homeURL);
    }

    @Test(priority = 10)
    public void verifyThatAfterSuccessfullyLoggedInUserIsBeingRedirectedToChooseProfilePage() {
        String validUsername = excelReader.getStringData("Usernames and Passwords",
                0, 1);
        String validPassword = excelReader.getStringData("Usernames and Passwords",
                1, 1);
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnLoginButton();
        waiterClickability(chooseProfilePage.chooseProfileButton);
        String chooseProfilePageURL = excelReader.getStringData("URL", 1, 1);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(chooseProfilePageURL, actualURL);
    }

    @Test (priority = 20)
    public void verifyThatAfterClickingOnChooseProfileButtonUserIsRedirectedToCreateProfilePage(){



        }
    }


