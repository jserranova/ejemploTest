package pageObject.ejemplo;

import ConstantGlobal.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import wrapper.Wrapper;


import java.util.ArrayList;
import java.util.List;

public class Ejemplo extends Wrapper {

    private JavascriptExecutor jsExecutor;

    public Ejemplo(WebDriver driver) {
        super(driver);
        this.jsExecutor = (JavascriptExecutor) driver;
    }

    public void cambiarPestana(WebDriver driver){
        jsExecutor.executeScript("window.open();");
        ArrayList<String> pestanas = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(pestanas.get(1));
        driver.navigate().to(Constants.PAG_1);
        pestanas = new ArrayList<String> (driver.getWindowHandles());
        jsExecutor.executeScript("window.open();");
        jsExecutor.executeScript("window.open();");
        driver.switchTo().window(pestanas.get(1)).close();

    }

    public void listaEstatica() throws InterruptedException {
        String exePath = "./src/test/resources/driver/geckodriver.exe";
        System.setProperty("webdriver.firefox.driver",exePath);
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php?controller=contact");
        //Instanciando Lista Estatica
        WebElement listaEstatica = driver.findElement(By.id("id_contact"));
        Select listaSeleccionada = new Select(listaEstatica);
        listaSeleccionada.selectByIndex(2);
        System.out.println(listaSeleccionada.getFirstSelectedOption().getText());
        Thread.sleep(3000);
        listaSeleccionada.selectByVisibleText("Customer service");
        System.out.println(listaSeleccionada.getFirstSelectedOption().getText());
        Thread.sleep(3000);
        listaSeleccionada.selectByValue("0");
        System.out.println(listaSeleccionada.getFirstSelectedOption().getText());
        Thread.sleep(3000);

    }

    public void eliminarNotificacion(){
        String exePath = "./src/test/resources/driver/geckodriver.exe";
        System.setProperty("webdriver.firefox.driver",exePath);
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(Constants.PAG_2);
        ChromeOptions notificaiones = new ChromeOptions();
        notificaiones.addArguments("--disable-notifications"); //desativa la notificaciones del navegador
        notificaiones.addArguments("--disable-notifications"); // desativa la extensiones del navegador
        driver.findElement(By.name("q")).click();

    }

    public void listaDinamica() throws InterruptedException {
        String exePath = "./src/test/resources/driver/geckodriver.exe";
        System.setProperty("webdriver.firefox.driver",exePath);
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
        Thread.sleep(2000);
        List<WebElement> opciones = driver.findElements(By.id("nav-flyout-searchAjax"));
        for (WebElement opcion:opciones) {
            System.out.println(opcion.getText());
            if (opcion.getText().contains("laptop stand for desk")) {
                opcion.click();
                System.out.println(driver.getTitle());
                break;

            }

        }

    }

    public void listaDependiente()throws InterruptedException{
        String exePath = "./src/test/resources/driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",exePath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://codigopostal.gob.ec");
        driver.findElement(By.xpath("/html/body/div[1]/section/div[4]/article[1]/div[1]/div[1]/div/p[1]/span/span/span/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[5]/div/ul/li[10]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/section/div[4]/article[1]/div[1]/div[1]/div/p[2]/span/span/span/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[13]/div/ul/li[8]")).click();
    }

    public void ventaEmergente()throws InterruptedException{
        String exePath = "./src/test/resources/driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",exePath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://winstoncastillo.com/ejercicios/atoc.html");
        driver.findElement(By.cssSelector("#testCasesAtoC > p:nth-child(2) > button")).click();
        String mensaje = driver.switchTo().alert().getText().toString();
        Thread.sleep(1000);
        System.out.println(mensaje);
        driver.switchTo().alert().accept();
    }


    public static void listaElementos(WebDriver driver)throws InterruptedException{

        By[] locators ={
                By.xpath("HOLA"),
                By.linkText("KLO"),
                By.id("KLOSMK")
        };


       List<WebElement> allElements = Wrapper.listFindElements_N(locators);

        for(WebElement element : allElements){
            element.click();
        }
    }
}



