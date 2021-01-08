package Utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtils {

    {
        String log4jConfPath = "log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
    }

    private static Logger LOG = LogManager.getLogger(FileUtils.class);


    public static XSSFSheet openExcelSheet(String excelFile, String sheetName) {
        XSSFSheet sheet;
        LOG.info("Opening an excel file");


        try {
            File file = new File("src/test/resources/" + excelFile + ".xlsx");
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheet(sheetName);

        } catch (FileNotFoundException ex) {
            LOG.error("Excel file(" + excelFile + ") provided does not exist");
            throw new RuntimeException(ex);

        } catch (IOException ex) {
            LOG.error("Could not read workbook");
            throw new RuntimeException(ex);

        }
        return sheet;

    }

    public static Map<Integer, List<Cell>> getAllDataFromSheet(XSSFSheet sheet) {
        Map<Integer, List<Cell>> excelData = new HashMap<>();
        int totalRows = sheet.getPhysicalNumberOfRows();

        for (int i = 0; i < totalRows; i++) {
            Row currentRow = sheet.getRow(i);
            List<Cell> cellList = new ArrayList<>();
            for (int j = currentRow.getFirstCellNum(); j < currentRow.getLastCellNum(); j++) {
                cellList.add(currentRow.getCell(j));
            }
            excelData.put(i, cellList);

        }

        return excelData;
    }

    public static List<Cell> getDataFromRow(XSSFSheet sheet,int rowNum){

            Row currentRow = sheet.getRow(rowNum);
            List<Cell> cellList = new ArrayList<>();
            for (int j = currentRow.getFirstCellNum(); j < currentRow.getLastCellNum(); j++) {
                cellList.add(currentRow.getCell(j));

        }
            return cellList;

    }




}
