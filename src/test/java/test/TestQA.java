package test;

import ConstantGlobal.Constants;
import configDriver.ConfigDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.ejemplo.Ejemplo;
import pageObject.login.Login;
import org.testng.Assert;

import java.time.Duration;

public class TestQA {

    WebDriver driver = ConfigDriver.setupChromeDriver();

   private Login login;
   private Ejemplo ejemplo;


    @BeforeClass
    public void init() throws Exception {
       // login = PageFactory.initElements(driver, Login.class);
        ejemplo = PageFactory.initElements(driver, Ejemplo.class);
    }

    @Test(priority = 1)
    public void test1() throws InterruptedException {
        ejemplo.ventaEmergente();


    }

    @Test(priority = 2)
    public void test2(){

    }




}
