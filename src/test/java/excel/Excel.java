package excel;

import ConstantGlobal.Constants;
import configDriver.ConfigDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Excel {

    WebDriver driver = ConfigDriver.setupChromeDriver();

    @BeforeMethod
    public void init(){

        driver.navigate().to(Constants.PAG_5);
        driver.manage().window().maximize();
    }

    @Test
    public void test(){
        System.out.println("Prueba OKEY");
    }
}
