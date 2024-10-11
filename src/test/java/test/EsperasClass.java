package test;

import ConstantGlobal.Constants;
import configDriver.ConfigDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class EsperasClass {

    private JavascriptExecutor jsExcutor;

    WebDriver driver = ConfigDriver.setupFirefoxDriver();



    @BeforeTest
    public void init(){
        driver.navigate().to(Constants.PAG_4);
        jsExcutor = (JavascriptExecutor) driver;
    }
    @Test
    public void esperaImplicita(){
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Actions mouse = new Actions(driver);
        jsExcutor.executeScript("window.scrollBy(0 , 500);");
        WebElement elementProducto = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[1]/div/a[1]/img"));
        mouse.moveToElement(elementProducto).perform();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[1]/div/a[2]/span")).click();
        System.out.println(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[3]/h1")).getText());
        driver.close();


    }
}
