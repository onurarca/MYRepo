package apachi_poi;

import Utils.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelIntro {

    @Test
    public void test1() throws IOException {
        File excelFile = new File("src/test/resources/TestExcel.xlsx");
        FileInputStream fileInputStream = new FileInputStream(excelFile);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row row1 = sheet.getRow(0);
        Cell cell1 = row1.getCell(0);
        System.out.println(cell1);
        Cell cell2 = row1.getCell(1);
        System.out.println(cell2);
        Cell cell3 = row1.getCell(2);
        System.out.println(cell3);

    }

    @Test
    public void getAllDataTest() throws IOException {
    //   File file = new File("src/test/resources/TestExcel.xlsx");
    //   FileInputStream fileInputStream = new FileInputStream(file);

    //   XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
    //   XSSFSheet sheet = workbook.getSheet("Sheet1");
        XSSFSheet sheet = FileUtils.openExcelSheet("TestExcel","Sheet1");
        Row row = sheet.getRow(0);

        //returns the number of total Rows
        int totalRows = sheet.getPhysicalNumberOfRows();

        for (int i =0; i<totalRows; i++){
            Row currentRow = sheet.getRow(i);
            for (int j = currentRow.getFirstCellNum(); j<currentRow.getLastCellNum(); j++){
                System.out.print(currentRow.getCell(j)+" | ");
            }
            System.out.println();

        }

    }



    @Test
    public void getDataFromRowTest()throws IOException{

        File file = new File("src/test/resources/TestExcel.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        Row row = sheet.getRow(1);

        for (int i = row.getFirstCellNum(); i<row.getLastCellNum(); i++){
            System.out.println(row.getCell(i));
        }

    }

    @Test
    public void utilsTest(){
        XSSFSheet sheet = FileUtils.openExcelSheet("TestExcel", "Sheet1");
        Map<Integer, List<Cell>>data = FileUtils.getAllDataFromSheet(sheet);
        System.out.println(data);
    }

    @Test
    public void utilTest2(){
        XSSFSheet sheet = FileUtils.openExcelSheet("TestExcel", "Sheet1");
        List<Cell> rowData = FileUtils.getDataFromRow(sheet,1);
        System.out.println(rowData);
    }

}
