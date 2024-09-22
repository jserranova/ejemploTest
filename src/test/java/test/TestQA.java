package test;

import ConstantGlobal.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.PageBase;

import java.time.Duration;

public class TestQA {

    private WebDriver driver;

    private PageBase pageBase;

    private WebDriver getWebDriver() {
        return null;
    }

    @BeforeClass
    public void init() throws Exception {
        System.setProperty(Constants.WEB_GOGLE, Constants.RUTA);
        driver = new ChromeDriver();
        driver.get(Constants.PAG);
        driver.manage().window().maximize();

        pageBase = PageFactory.initElements(driver, PageBase.class);


    }

    @Test
    public void test() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        pageBase.userLogin();

    }

    @AfterTest
    public void close() {
        //driver.close();
    }

}
