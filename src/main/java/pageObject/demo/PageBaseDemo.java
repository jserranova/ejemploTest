package pageObject.demo;

import ConstantGlobal.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.wrapper.Wrapper;

public class PageBaseDemo extends Wrapper {

    @FindBy(id = Constants.USERNAME)
    private WebElement inputUserName;
    @FindBy(id = Constants.PASSWORD)
    private WebElement inputPassword;
    @FindBy(xpath = Constants.BUTTON_LOGIN)
    private WebElement inputButtonLogin;

    //locator
    private By userName = By.id("user-name");
    private By password = By.id("password");
    private By existButton = By.xpath("//input[@type='submit']");

    public PageBaseDemo(WebDriver driver) {
        super(driver);
    }

    public void userLogin() {
        clearInput(inputUserName);
        insertValue(userName, "stardard-user");
        clearInput(inputPassword);
        insertValue(password, "secret_sauce");
        clickButton(inputButtonLogin);
    }

    public Boolean isExistElement() {

        return isDisplayed(existButton);

    }
}
