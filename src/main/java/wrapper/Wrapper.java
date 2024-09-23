package wrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Wrapper {

    private WebDriver driver;

    //Builder
    public Wrapper(WebDriver driver) {

        this.driver = driver;
    }

    // Locate an item
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    //Locate item list
    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    // Get a text
    public String getText(WebElement element) {
        return element.getText();
    }

    // text
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    //input Text
    public void sendKeys(By locator, String inputText)
    {
        driver.findElement(locator).sendKeys(inputText);
    }
    public void sendkeys(WebElement webE, String texto){
        webE.clear();
        webE.sendKeys(texto);
    }

    // Click Button
    public void clickButton(By locator) {
        driver.findElement(locator).click();
    }
    public void clickButton(WebElement element) {
        element.click();
    }

    //Clear Box
    public void clearInput(WebElement element) {
        element.isDisplayed();
    }


    //whether an element is present or not
    public boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }

    }

    //if element exist
    public Boolean isExistElements(By locator) {

        if (driver.findElements(locator).size() != 0) {
            return driver.findElements(locator).size() != 0;
        } else {
            return false;
        }
    }

    //Enter Url
    public void visitUrl(String url) {
        driver.get(url);
    }

    //Refrescar pagina o Actualizar
    public void refresh(WebDriver driver){
        driver.navigate().refresh();
    }

    // ir atras
    public void back(WebDriver driver){
        driver.navigate().back();
    }

    // ir adelante
    public void forward(WebDriver driver){
        driver.navigate().forward();
    }
    public  void listaEstatica(WebDriver driver, WebElement webE) throws InterruptedException {
        Select listaSeleccionada = new Select(webE);
        listaSeleccionada.selectByIndex(2);
        //Metodo 2
        /**
         System.out.println(listaSeleccionada.getFirstSelectedOption().getText());
         Thread.sleep(3000);
         listaSeleccionada.selectByVisibleText("Customer service");**/
        //Metodo 3
        /**
         System.out.println(listaSeleccionada.getFirstSelectedOption().getText());
         Thread.sleep(3000);
         listaSeleccionada.selectByValue("0");
         System.out.println(listaSeleccionada.getFirstSelectedOption().getText());
         Thread.sleep(3000);
         **/
    }
    // Para cambair de una pestaña a la otra
    public void cambiarPestana(WebDriver driver){
        ArrayList<String> pentanas = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(pentanas.get(1)).close();
    }

    // Colocar el Mouse sobre cualquier lugar
    public void actionMouse(){
        Actions accionRaton = new Actions(driver);
        WebElement opcion = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[1]/span"));
        accionRaton.moveToElement(opcion).perform();
    }


}
