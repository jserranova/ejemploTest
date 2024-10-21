package pageObject.ejemplo;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LeerExcel {

    public LeerExcel(){

    }

    // Este metodo lee todas las celda de la fila
    public void leerExel(String rutaExcel, String leerHojaExcel) throws IOException {

        File file = new File(rutaExcel);  // se le pasa la ruta del excel

        FileInputStream inputStream = new FileInputStream(file);  // los datos de Archivo

        XSSFWorkbook libroTrabado = new XSSFWorkbook(inputStream); // se crea el objeto donde se Guarda el libro de excel(el Fichero)

        XSSFSheet hoja = libroTrabado.getSheet(leerHojaExcel);    // se crea el objeto donde se guarda la hoja de excel

        int contadorFila =  hoja.getLastRowNum() - hoja.getFirstRowNum();  // Guardar cuantas fila de datos hay en la hoja excel

         for (int i=0 ; i<=contadorFila; i++ ){
             XSSFRow contador = hoja.getRow(i);  //interactua con las Filas
               for (int j = 0; j < contador.getFirstCellNum(); j++){  // interatua con la celda de las filas
                   System.out.println(contador.getCell(j).getStringCellValue() + "||");
               }
         }


    }

    // Metodo para un valor de celda especifico
    public String getCellValue(String filepath, String sheetName, int rowNumber, int cellNumber) throws IOException {

        File file = new File(filepath);  // se le pasa la ruta del excel

        FileInputStream inputStream = new FileInputStream(file);  // los datos de Archivo

        XSSFWorkbook newWorkbook= new XSSFWorkbook(inputStream); // se crea el objeto donde se Guarda el libro de excel(el Fichero)

        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);    // se crea el objeto donde se guarda la hoja de excel

        XSSFRow row = newSheet.getRow(rowNumber);

        XSSFCell cell = row.getCell(cellNumber);

         return cell.getStringCellValue();
    }
}
