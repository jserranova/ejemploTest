package excel;

import ConstantGlobal.Constants;
import configDriver.ConfigDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.ejemplo.EscribirExcel;
import pageObject.ejemplo.LeerExcel;

import java.io.IOException;

public class Excel {

    WebDriver driver = ConfigDriver.setupFirefoxDriver();
    private LeerExcel leerExcel;
    private EscribirExcel escribirExcel;


    @CacheLookup
    private By searchBoxLocator = By.id("search_query_top");
    private By buttonSearch = By.name("submit_search");
    private By resultTextLocator = By.cssSelector("span.heading-counter");

    @BeforeMethod
    public void init(){

        driver.navigate().to(Constants.PAG_5);
        driver.manage().window().maximize();
        leerExcel = PageFactory.initElements(driver, LeerExcel.class);
        escribirExcel = PageFactory.initElements(driver, EscribirExcel.class);

    }

    @Test
    public void test() throws IOException {
        // Se lee el valor de la primera Cellda
         String filepath = "D:\\Automatizacion_Selenuim\\Test.xlsx";
         int numero = 1;
         int num=1;
         for(int i = 0 ;  i < 3; i++ ) {
             String searchText = leerExcel.getCellValue(filepath, "test", numero-1, 0);
             driver.findElement(searchBoxLocator).sendKeys(searchText);
             driver.findElement(buttonSearch).click();
             String resultText = driver.findElement(resultTextLocator).getText();
             System.out.println(resultText);
             driver.findElement(searchBoxLocator).clear();
             //Assert.assertEquals("1 result has been found.", resultText);
             numero++;


             // Se escribe el valor de la primera Selda
                 leerExcel.leerExel(filepath, "test");

                 escribirExcel.writeCellValue(filepath, "test",num-1,1, resultText);

                 leerExcel.leerExel(filepath, "test");
                 num++;


         }
        // Se escribe el valor de la primera Selda




    }
}
