package pageObject.menuPage;

import ConstantGlobal.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.wrapper.Wrapper;

public class MenuPage extends Wrapper {

    private By shoppingCart = By.cssSelector(Constants.SHOPPING_CART);
    private By burgerButton = By.cssSelector(Constants.BURGER_BUTTON);
    private By aboutOptionsButton = By.cssSelector(Constants.SIDEBAR_BUTTON_OPTION);
    private By logoPageWeb = By.cssSelector(Constants.LOGO_PAGE_WEB);


    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public void do_now() {
        isDisplayed(shoppingCart);
    }

    public void do_when() {
        clickButton(burgerButton);
        clickButton(aboutOptionsButton);
    }

    public void do_then() {
        isExistElements(logoPageWeb);
    }

    public void returnLastView(){
        returnPage();
    }
}
