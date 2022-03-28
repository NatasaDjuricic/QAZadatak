package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Napravila sam jedan Test Suit gde svi testovi moraju proci i to redom kako sam ih definisala
//kako bih smatrala da je funkcionalnost u skladu sa zahtevima koji su postavljeni
public class TestPage extends BasePage {
    @BeforeMethod
    public void setUpPage() {
        //maksimiziram prozor pre svakog testa
        driver.manage().window().maximize();

    }

    //ovaj test ce se izvrsiti prvi zbog vrednosti prioriteta koji sam mu dodelila
    @Test(priority = 10)
    //Verifikuj da je nakon uspesnog logovanja korisnik preusmeren na stranicu za izbor profila
    public void verifyThatAfterSuccessfullyLoggedInUserIsBeingRedirectedToChooseProfilePage() {
        driver.navigate().to(homeURL); //idi na homeURL koji citam iz excela i koji sam definisala u BasePage
        String validUsername = excelReader.getStringData("Usernames and Passwords",
                0, 1); //procitaj validan username iz excel fajla koji sam definisala u BasePage
        String validPassword = excelReader.getStringData("Usernames and Passwords",
                1, 1); //procitaj validan password iz excel fajla koji sam definisala u BasePage
        loginPage.inputUsername(validUsername); //unesi validan username u "Username" polje
        loginPage.inputPassword(validPassword); //unesi validan password u "Password" polje
        loginPage.clickOnLoginButton(); //klikni na "LOGIN" dugme
        //ovaj waiter stavljam da bi drajver sacekao dok "Create Profile" dugme ne bude klikabilno
        waiterClickability(chooseProfilePage.createNewProfileButton);
        String expectedURL = chooseProfilePageURL; //procitaj iz excel fajla URL stranice na koju treba da budem preusmerena
        String actualURL = driver.getCurrentUrl(); //procitaj URL stranice na koju sam stvarno preusmerena
        Assert.assertEquals(expectedURL, actualURL); //uporedi da li su te dve stranice identicne

    }

    //Ovaj test ce se izvrsiti drugi po redu
    @Test(priority = 20)
    //Verifikuj da je korisnik nakon klika na "Create New Profile" dugme preusmeren
    //na stranicu gde moze da kreira profil
    public void verifyThatAfterClickingOnCreateNewProfileButtonUserIsRedirectedToCreateProfilePage() {
        chooseProfilePage.clickOnCreateNewProfileButton(); // klikni na "Create New Profile" dugme
        String expectedURL = createProfilePageURL; //smesti u promenljivu tipa String vrednost ocekivani URL iz excel fajla
        String actualURL = driver.getCurrentUrl(); //procitaj URL stranice na kojoj se stvarno nalazim
        Assert.assertEquals(expectedURL, actualURL); //uporedi da li su te dva URL identicna

    }

    //Ovaj test ce se izvrsiti treci po redu
    @Test (priority = 30)
    //Verifikuj da korisnik moze da napravi profil
    public void verifyThatUserCanCreateProfile() throws InterruptedException {
      String validProfileName = excelReader.getStringData("Profile Names",
              1, 0); //procitaj validan profile name iz excel fajla
      createProfilePage.inputProfileName(validProfileName); // unesi validan profile name u "Name" placeholder
      //procitaj vrednost koja se nalazi u polju "Profile Name"
      String profileNameValue = createProfilePage.profileName.getAttribute("value");
      waiterPresenceOfElement(createProfilePage.age); //sacekaj da se ucita element koji smo nazvali "age"
      scroll(createProfilePage.age); //skroluj do elementa "age"
      createProfilePage.clickOnAge(); //klikni na element "age"
      //procitaj tekstualnu vrednost koja se nalazi u elementu "age"
      String ageValue = createProfilePage.age.getText();
      //skroluj do elementa "birthYear"
      scroll(createProfilePage.birthYear);
      String validBirthYear = excelReader.getStringData("Birth Years",
              1, 0); //procitaj validnu godinu rodjenja iz excel fajla
      //unesi validnu godinu rodjenja u "Enter your birth year" polje
      createProfilePage.inputBirthYear(validBirthYear);
      //procitaj vrednost koja se nalazi u polju "Enter your birth year"
      String birthYearValue = createProfilePage.birthYear.getAttribute("value");
      Thread.sleep(2000); //Sacekaj 2 sekunde.
      createProfilePage.clickOnAvatar(); //klikni na avatar
      //procitaj vrednost src atributa elementa "avatar" na stranici na kojoj kreiramo profil
      String avatarSourceOnCreateProfilePage = createProfilePage.avatar.getAttribute("src");
      scroll(createProfilePage.createProfileButton); //skroluj do "Create profile" dugmeta
      createProfilePage.clickOnCreateProfileButton(); //klikni na "Create profile" dugme
      Thread.sleep(2000); //sacekaj 2 sekunde.
      //proveri da li je prikazano "Choose profile" dugme
      Assert.assertTrue(deleteProfilePage.chooseProfileButton.isDisplayed());
      String expectedURL = deleteProfilePageURL; //procitaj iz excel fajla URL na koji treba da budemo preusmereni
      String actualURL = driver.getCurrentUrl(); //procitaj na kojem URL se zaista nalazimo
      Assert.assertEquals(expectedURL, actualURL); //uporedi da li su URL identicni
      //procitaj vrednost src atributa elementa "avatar" na stranici na kojoj mozemo da obrisemo vec kreiran profil
      String avatarSourceOnDeletePage = deleteProfilePage.deletePageAvatar.getAttribute("src");
      //procitaj tekstualnu vrednost elementa "deletePageName"
      String profileNameValueOnDeletePage = deleteProfilePage.deletePageName.getText();
      //uporedi da li je na stranici na kojoj je prikazan kreiran profil avatar identican
      //kao onaj koji koji smo izabrali prilikom kreiranja stranice
      Assert.assertEquals(avatarSourceOnCreateProfilePage, avatarSourceOnDeletePage);
      //uporedi da li je na stranici na kojoj je prikazan kreiran profil ime isto
      // kao ono ime koje smo uneli prilikom kreiranja profila
      Assert.assertEquals(profileNameValue, profileNameValueOnDeletePage);
      scroll(deleteProfilePage.deleteButton); //skroluj do "Delete profile" dugmeta
      //proveri da li je na stranici prikazano "Delete profile" dugme
      //To nam govori da smo kreirali profil jer ne treba da imamo opciju da obrisemo nesto sto ne postoji
      Assert.assertTrue(deleteProfilePage.deleteButton.isDisplayed());

    }

    //ovaj test ce se izvrsiti poslednji
    @Test (priority = 40)
    //Verifikuj da korisnik moze uspesno da obrise profil
    public void verifyThatUserCanSuccessfullyDeleteCreatedProfile() throws InterruptedException {
       deleteProfilePage.clickOnChooseProfileButton(); //klikni na "Choose profile" dugme
       //sacekaj dok kreiran profil ne bude klikabilan
       waiterClickability(chooseProfilePage.profileButton);
       //proveri da li je prikazan kreirani profil
       Assert.assertTrue(chooseProfilePage.profileButton.isDisplayed());
       chooseProfilePage.clickOnProfileButton(); //klikni na profil koji je kreiran
       waiterClickability(deleteProfilePage.deleteButton); //sacekaj dok "Delete Profile" dugme ne bude klikabilno
       scroll(deleteProfilePage.deleteButton); //skroluj do "Delete profile" dugmeta
       deleteProfilePage.clickOnDeleteProfileButton(); //klikni na "Delete profile" dugme
       Thread.sleep(2000); //sacekaj 2 sekunde
       String expectedURL = chooseProfilePageURL; //procitaj na kojoj URL treba da budemo
       String actualURL = driver.getCurrentUrl(); //procitaj na kojoj smo zaista URL
       Assert.assertEquals(expectedURL, actualURL); //uporedi da li su URL identicne


    }



}



