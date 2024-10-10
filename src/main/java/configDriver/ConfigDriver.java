package configDriver;

import ConstantGlobal.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ConfigDriver {

    public static WebDriver setupChromeDriver(){
        System.setProperty(Constants.WEB_GOGLE,Constants.RUTA_GOOGLE);
        WebDriver driver = new ChromeDriver();
        driver.get(Constants.PAG);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver setupFirefoxDriver(){
        System.setProperty(Constants.WEB_FIREFOX, Constants.RUTA_FIREFOX);
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }


}


