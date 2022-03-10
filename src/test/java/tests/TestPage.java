package tests;

import base.BasePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestPage extends BasePage {
    @BeforeMethod
    public void setUpPage() {
        driver.manage().window().maximize();
        driver.navigate().to(homeURL);
    }


        @Test
        public void test1 (){

        }
    }
