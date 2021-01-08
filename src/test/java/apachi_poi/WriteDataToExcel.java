package apachi_poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;

public class WriteDataToExcel {
    @Test
    public void writeTest() throws IOException {

        File file = new File("src/test/resources/TestExcel.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row newRow = sheet.createRow(3);
        Cell newCell = newRow.createCell(0);
        newCell.setCellType(CellType.STRING);
        newCell.setCellValue("Onur2");

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);


    }

    @Test
    public void writeTest2() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("src/test/resources/TestExcel.xlsx"));
        XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);

        XSSFSheet sheet = workbook.getSheet("Sheet1");
        Row row = sheet.getRow(1);
        Cell cell =row.getCell(0);
        cell.setCellValue("Jerry");

        FileOutputStream fileOutputStream = new FileOutputStream(new File("src/test/resources/TestExcel.xlsx"));
        workbook.write(fileOutputStream);
        workbook.close();


    }

    @Test
    public void deleteTest() throws IOException {
        File file = new File("src/test/resources/TestExcel.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet =workbook.getSheet("Sheet1");
        Row row = sheet.getRow(3);
        Cell cell = row.getCell(0);
        row.removeCell(cell);


        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        fileInputStream.close();
        workbook.close();


    }


}
