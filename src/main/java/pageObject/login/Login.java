package pageObject.login;

import ConstantGlobal.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import wrapper.Wrapper;

public class Login extends Wrapper {


    public Login(WebDriver driver)  {
        super(driver);

    }

    @CacheLookup

    // aqui se entrega By locator
    private By password = By.id("password");
    private By user = By.id("user-name");

    // aqui se entrega el webElement
   @FindBy(id = "login-button")private WebElement btnLogin;

    public void login(){
        sendKeys(user, Constants.USERNAME);
        sendKeys(password, Constants.PASSWORD);
        clickButton(btnLogin);

    }
}
