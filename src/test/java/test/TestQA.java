package test;

import ConstantGlobal.Constants;
import configDriver.ConfigDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.login.Login;

import java.time.Duration;

public class TestQA {

   private Login login;

    @BeforeClass
    public void init() throws Exception {
        WebDriver driver = ConfigDriver.setupChromeDriver();
        login = PageFactory.initElements(driver, Login.class);
    }

    @Test
    public void test() {
     login.login();

    }



}
