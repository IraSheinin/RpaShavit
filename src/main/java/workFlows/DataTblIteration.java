package workFlows;
import com.hp.lft.sdk.GeneralLeanFtException;
import utilities.ApplicationManager;
import utilities.ExcelUtils;
import utilities.Log;
import utilities.exceptions.FinishedInTheMiddleException;

import java.util.ArrayList;
import java.util.List;

import static utilities.ApplicationManager.getNumOfColumnsInExcel;

public abstract class DataTblIteration {
    private List<String> excelDataValues;
    private ExcelUtils excelFile;
    private int excelResultCol;
    private int excelStartRowCol;
    protected static String excelResultMsg;
    protected static ApplicationManager appManager;
    private int colNumbersExcel;
    private int excelCurrentRunRow;

    public DataTblIteration (ApplicationManager appManager){
        this.appManager=appManager;
        excelFile = appManager.getExcelDataHelper().getExcelDataFile();
        excelDataValues = new ArrayList<>();
        colNumbersExcel = getNumOfColumnsInExcel()-1;
        excelResultCol = colNumbersExcel +1;
        excelStartRowCol = colNumbersExcel +2;
    }



    public void act_IterateThroughExcelData() throws InterruptedException {
        excelCurrentRunRow = (int) ((excelFile.getNumericCellData(0, excelStartRowCol))-1);
        while(excelFile.getCellData(excelCurrentRunRow,0)!="") {
            excelResultMsg = "";
            takeRowData();
            try {
                runTheFlow();
                updateExcelFile();
            } catch (GeneralLeanFtException e) {
                excelResultMsg = "Fail";
                updateExcelFile();
                appManager.dismissApp("a_csm.exe");
                break;
            } catch (FinishedInTheMiddleException e) {
                updateExcelFile();
            }
        }
        if (excelFile.getCellData(excelCurrentRunRow,0)==""){
            appManager.mainLoopCompleted = true;
            Log.info("iterateThroughDataTbl: ApplicationManager.setMainLoopCompleted(true)");
        }
    }

    void updateExcelFile(){
        if (appManager.isInsideLoopCompleted()) {
            Log.info("InsideLoopCompleted");
            Log.info("excelResultMsg: "+excelResultMsg);
            excelFile.setData(excelCurrentRunRow, excelResultCol, excelResultMsg);
            excelCurrentRunRow++;
            excelFile.setData(0, excelStartRowCol, excelCurrentRunRow + 1);
        }else{
            Log.info("InsideLoop Not Completed");
            excelFile.setData(excelCurrentRunRow, excelResultCol, "not completed yet");
            appManager.insideLoopCompleted = true;// back to default value
            }
        }

    protected abstract void act_GoToCsm() throws GeneralLeanFtException;

    protected abstract void runTheFlow() throws GeneralLeanFtException, FinishedInTheMiddleException, InterruptedException;

    protected List<String> getExceldataValues(){
        return excelDataValues;

    }

    private void takeRowData(){
        for (int i = 0; i<= colNumbersExcel; i++) {
            excelDataValues.add(i, excelFile.getCellData(excelCurrentRunRow, i));
        }
    }

}
