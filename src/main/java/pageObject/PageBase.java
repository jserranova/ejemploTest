package pageObject;

import ConstantGlobal.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageBase {

    private WebDriver driver;


    // declarar constanste
    @FindBy(id= Constants.USERNAME)
    private WebElement inputUserName;
    @FindBy(id = Constants.PASSWORD)
    private WebElement inputPassword;
    @FindBy(xpath = Constants.BUTTON_LOGIN)
    private WebElement inputButtonLogin;


    // getter and Setter

    public WebElement getInputUserName(){
        return inputUserName;
    }

    public WebElement getInputPassword(){
        return inputPassword;
    }
    public WebElement getInputButtonLogin(){
        return inputButtonLogin;
    }


    public void userLogin(){
        inputUserName.clear();
        inputUserName.sendKeys("stardard_user");

        inputPassword.clear();
        inputPassword.sendKeys("secret_sauce");
        inputButtonLogin.click();
    }

    public void visitUrl(String url){
        driver.get(url);
    }
}





