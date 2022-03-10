package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

import java.io.IOException;
import java.time.Duration;

// U base paketu pravim BasePage
public class BasePage {
    public WebDriver driver; //deklarisem driver
    public WebDriverWait wdwait; //deklarisem waiter
    public ExcelReader excelReader; //deklarisem ExcelReader
    public LoginPage loginPage;
    public String homeURL;

    //U ovoj klasi pravim @BeforClass koji ce se pokrenuti pre TestPage-a
    // inicijalizujem drivere, waiter, excelReader, stranice i URL-ove
    @BeforeClass

        public void setup() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        excelReader = new ExcelReader("TextBook.xlsx"); // odavde vucem unose u program
        loginPage = new LoginPage(driver);
        homeURL = excelReader.getStringData("URL",0,1);
    }
        public void waiterVisibility(WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));

        }

        public void waiterClickability(WebElement element) {
        wdwait.until(ExpectedConditions.elementToBeClickable(element));

        }

        public void scroll(WebElement element) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);" , element);
        }

       /* @AfterClass
        public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
        }*/


}