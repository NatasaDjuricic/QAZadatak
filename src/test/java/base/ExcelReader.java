package base;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    File file;
    FileInputStream fis;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;
    DataFormatter dataFormatter;

    public ExcelReader(String filePath) throws IOException {
        file = new File(filePath);
        fis = new FileInputStream(file);
        wb = new XSSFWorkbook(fis);
        dataFormatter = new DataFormatter();
    }

    public String getStringData(String sheetName, int rowNumber, int cellNumber) {
        sheet = wb.getSheet(sheetName);
        row = sheet.getRow(rowNumber);
        cell = row.getCell(cellNumber);
        return dataFormatter.formatCellValue(cell);
    }

    public int getIntegerData(String sheetName, int rowNumber, int cellNumber) {
        sheet = wb.getSheet(sheetName);
        row = sheet.getRow(rowNumber);
        cell = row.getCell(cellNumber);
        return (int) cell.getNumericCellValue();
    }

    public int getLastRow(){
        return sheet.getLastRowNum();
    }



}
