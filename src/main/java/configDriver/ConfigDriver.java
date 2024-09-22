package configDriver;

import ConstantGlobal.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ConfigDriver {

    public static WebDriver setupChromeDriver(){
        System.setProperty(Constants.WEB_GOGLE,Constants.RUTA);
        WebDriver driver = new ChromeDriver();
        driver.get(Constants.PAG);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver setupFirefoxDriver(){
        String exePath = "./src/test/resources/driver/geckodriver.exe";
        System.setProperty("webdriver.firefox.driver",exePath);
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }


}


