package test;

import ConstantGlobal.Constants;
import configDriver.ConfigDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import wrapper.Wrapper;

public class TestIframe {


    WebDriver driver = ConfigDriver.setupFirefoxDriver();


    @BeforeTest
    public void init(){
        driver.navigate().to(Constants.PAG_3);

    }

    @Test
    public void test() {
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        driver.switchTo().frame("iframe-prueba"); // primera opcion
        //driver.switchTo().frame(0); // esta es la segunda opcion opcion
        System.out.println(driver.findElement(By.xpath("/html/body/div[2]/a/p")).getText());
        //driver.findElement(By.xpath("/html/body/div[2]/a/p")).click();
        //driver.switchTo().defaultContent(); // primera opcion
        driver.switchTo().parentFrame(); // segunda opcion
        System.out.println(driver.findElement(By.xpath("/html/body/div/section[6]/p[1]/span[1]")).getText());
        driver.close();
    }
}
