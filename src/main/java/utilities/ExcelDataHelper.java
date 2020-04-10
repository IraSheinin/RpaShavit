package utilities;

import utilities.ExcelUtils;

public class ExcelDataHelper {

    private ExcelUtils excelDataFile;

    public ExcelDataHelper(String excelPath){
        excelDataFile = new ExcelUtils(excelPath);
    }

    public ExcelUtils getExcelDataFile(){
        return excelDataFile;
    }

}
