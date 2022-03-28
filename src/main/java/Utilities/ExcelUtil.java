package Utilities;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;

public class ExcelUtil {
    private static HSSFWorkbook workbook;
    private static HSSFSheet sheet;
    private static HSSFRow row;

    private void setExcelFile(String excelFilePath, String sheetName) throws IOException {
        File file  = new File(excelFilePath);
        FileInputStream inputStream = new FileInputStream(file);
        workbook = new HSSFWorkbook(inputStream);
        sheet = workbook.getSheet(sheetName);
    }
    public String getCellData(int rowNumber, int cellNumber){
        HSSFCell cell = sheet.getRow(rowNumber).getCell(cellNumber);
        return cell.getStringCellValue();
    }
    public int getRowCountInSheet(){
        return sheet.getLastRowNum()-sheet.getFirstRowNum();
    }
    public void setCellValue(int rowNum, int cellNum, String cellValue, String excelFilepath) throws IOException {
        sheet.getRow(rowNum).createCell(cellNum).setCellValue(cellValue);
        FileOutputStream outputStream = new FileOutputStream(excelFilepath);
        workbook.write(outputStream);
    }
}
