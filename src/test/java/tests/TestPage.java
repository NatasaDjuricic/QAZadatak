package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestPage extends BasePage {
    @BeforeMethod
    public void setUpPage() {
        driver.manage().window().maximize();

    }

    @Test(priority = 10)
    public void verifyThatAfterSuccessfullyLoggedInUserIsBeingRedirectedToChooseProfilePage() throws InterruptedException {
        driver.navigate().to(homeURL);
        String validUsername = excelReader.getStringData("Usernames and Passwords",
                0, 1);
        String validPassword = excelReader.getStringData("Usernames and Passwords",
                1, 1);
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnLoginButton();
        waiterClickability(chooseProfilePage.createNewProfileButton);
        String expectedURL = chooseProfilePageURL;
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);

    }

 @Test(priority = 20)
   public void verifyThatAfterClickingOnChooseProfileButtonUserIsRedirectedToCreateProfilePage() {
        chooseProfilePage.clickOnCreateNewProfileButton();
        String expectedURL = createProfilePageURL;
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);

    }

 @Test (priority = 30)
    public void verifyThatUserCanCreateProfile() throws InterruptedException {
      String validProfileName = excelReader.getStringData("Profile Names", 1, 0);
      createProfilePage.inputProfileName(validProfileName);
      String profileNameValue = createProfilePage.profileName.getAttribute("value");
      waiterPresenceOfElement(createProfilePage.age);
     System.out.println(profileNameValue);
     scroll(createProfilePage.age);
      createProfilePage.clickOnAge();
     String ageValue = createProfilePage.age.getText();
     System.out.println(ageValue);
      scroll(createProfilePage.birthYear);
      String validBirthYear = excelReader.getStringData("Birth Years", 1, 0);
      createProfilePage.inputBirthYear(validBirthYear);
      String birthYearValue = createProfilePage.birthYear.getAttribute("value");
     System.out.println(birthYearValue);
      Thread.sleep(5000);
      createProfilePage.clickOnAvatar();
     String avatarSourceOnCreateProfilePage = createProfilePage.avatar.getAttribute("src");
     System.out.println(avatarSourceOnCreateProfilePage);
     scroll(createProfilePage.createProfileButton);
    createProfilePage.clickOnCreateProfileButton();
    Thread.sleep(2000);
    String expectedURL = deleteProfilePageURL;
     System.out.println("delete page url: " + expectedURL);
    String actualURL = driver.getCurrentUrl();
     System.out.println(actualURL);
    Assert.assertEquals(expectedURL, actualURL);
    Thread.sleep(2000);
    String avatarSourceOnDeletePage = deleteProfilePage.deletePageAvatar.getAttribute("src");
     System.out.println(avatarSourceOnDeletePage);
    String profileNameValueOnDeletePage = deleteProfilePage.deletePageName.getText();
     System.out.println(profileNameValueOnDeletePage);
     Assert.assertEquals(avatarSourceOnCreateProfilePage, avatarSourceOnDeletePage);
     Assert.assertEquals(profileNameValue, profileNameValueOnDeletePage);




    }



}



