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
        return driver;
    }

    public static WebDriver setupFirefoxDriver(){
        System.setProperty(Constants.WEB_FIREFOX, Constants.RUTA_FIREFOX);
        WebDriver driver = new FirefoxDriver();
        return driver;
    }


}


