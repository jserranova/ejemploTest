package pageObject.ejemplo;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class EscribirExcel {


    public EscribirExcel(){

    }

    //Metodo permite escribir una lista de Datos al Excel.

    public void escribiExcel(String rutaExcel, String hojaExcel, String[] dataEscribir) throws IOException {

        File file = new File(rutaExcel);  // se le pasa la ruta del excel

        FileInputStream inputStream = new FileInputStream(file);  // los datos de Archivo

        XSSFWorkbook libroTrabado = new XSSFWorkbook(inputStream); // se crea el objeto donde se Guarda el libro de excel(el Fichero)

        XSSFSheet hoja = libroTrabado.getSheet(hojaExcel);    // se crea el objeto donde se guarda la hoja de excel

        int contadorFila =  hoja.getLastRowNum() - hoja.getFirstRowNum();  // Guardar cuantas fila de datos hay en la hoja excel

        XSSFRow contador = hoja.getRow(0);   // Crear Objeto Fila

        XSSFRow nuevoContador = hoja.createRow(1); // Crear nueva  fila, de donde se parte escribiendo

        for (int i=0; i< contador.getLastCellNum(); ++i){
            XSSFCell nuevaCelda = nuevoContador.createCell(i);
            nuevaCelda.setCellValue(dataEscribir[i]);
        }

        inputStream.close();

        FileOutputStream salidaDato = new FileOutputStream(file);  // Permite Escribir en el Excel

        libroTrabado.write(salidaDato);

        salidaDato.close();


    }

    //Metodo que Permite crear un valor en una Celda Especifica

    public void writeCellValue(String filepath, String sheetName, int rowNumber, int cellNumber, String resultText) throws IOException {

        File file = new File(filepath);  // se le pasa la ruta del excel

        FileInputStream inputStream = new FileInputStream(file);  // los datos de Archivo

        XSSFWorkbook  newWorkbook= new XSSFWorkbook(inputStream); // se crea el objeto donde se Guarda el libro de excel(el Fichero)

        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);    // se crea el objeto donde se guarda la hoja de excel

        XSSFRow   row = newSheet.getRow(rowNumber);             // Se crea la fila y se pasa como parametro el numero de fila que se quiere acceder.

        XSSFCell firsCell = row.getCell(cellNumber-1);

        System.out.println("first cell value is: " + firsCell.getStringCellValue());

        XSSFCell nextCell = row.createCell(cellNumber);
        nextCell.setCellValue(resultText);

        System.out.println("nextCell value: " +nextCell.getStringCellValue());

        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(file);
        newWorkbook.write(outputStream);
        outputStream.close();


    }
}
