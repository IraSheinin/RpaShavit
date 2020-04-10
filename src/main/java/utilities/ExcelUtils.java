package utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;

public class ExcelUtils {
    static XSSFWorkbook workBook;
    static XSSFSheet sheet;
    static File excelFile;
    static FileInputStream fis;
    static FileOutputStream fos;

    public ExcelUtils(String filePath) {
        excelFile = new File(filePath);
       try {
            fis = new FileInputStream(excelFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workBook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = workBook.getSheetAt(0);
    }

    public void setData(int row, int column, String data){
        sheet.getRow(row).createCell(column).setCellValue(data);
        try {
            fis.close();
            fos = new FileOutputStream(excelFile);
            workBook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setData(int row, int column, double data){
        sheet.getRow(row).createCell(column).setCellValue(data);
        try {
            fis.close();
            fos = new FileOutputStream(excelFile);
            workBook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getCellData(int rowNum, int colNum){

        try {
        return sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
        }catch(NullPointerException NPE)
        {
            return "";
        }
    }



    public double getNumericCellData(int rowNum, int colNum){

        try {
            return sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
        }catch(NullPointerException NPE)
        {
            return 0;
        }
    }

    private int getRowCount() {
        return sheet.getLastRowNum() + 1;
    }

    private int getColumnCount() {
        return sheet.getRow(0).getLastCellNum();
    }

    public void quit(){
        try {
            excelFile = null;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
