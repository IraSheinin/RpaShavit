package windows.csmWindows;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.powerbuilder.Button;
import com.hp.lft.sdk.powerbuilder.EditField;
import com.hp.lft.sdk.powerbuilder.Table;
import com.hp.lft.sdk.Keys;
import com.hp.lft.sdk.powerbuilder.Window;
import com.hp.lft.sdk.stdwin.Menu;
import helpers.shavitHelpers.PbObjectsBuilder;
import helpers.shavitHelpers.PbWindowBuilder;
import helpers.shavitHelpers.WinDesc;
import utilities.ApplicationManager;
import utilities.Log;

import java.util.ArrayList;
import java.util.List;



public class UiActions {
    protected PbWindowBuilder winBuilder;
    protected PbObjectsBuilder pbObjectsBuilder;
    protected List<WinDesc> winDescList;
    protected Window pbWin;
    protected WinDesc winDesc0;

    public void buildPageObject(List<WinDesc> winDesc) {
        pbWin = winBuilder.getPbWin(winDesc);

    }

    public UiActions() {
        winBuilder = new PbWindowBuilder();
        pbObjectsBuilder = new PbObjectsBuilder();
        winDescList = new ArrayList<>();
        winDesc0 = new WinDesc();
        if (ApplicationManager.getApplicationType().toLowerCase().contentEquals("csm")) {
            winDesc0.setName("w_main_frame");
        }
        else {
            winDesc0.setName("w_crm_main_frame");
        }
        winDescList.add(0, winDesc0);
}

    public boolean winExist(int timeout) throws GeneralLeanFtException {
        boolean ind = false;
        ind = pbWin.waitUntilExists(timeout);
        return ind;
    }

    public void closeWin(int timeout) throws GeneralLeanFtException {
        Log.info(getClass().getName() + " closeWin " + pbWin.getObjectName() + " started");
        pbWin.waitUntilExists(timeout);
        pbWin.close();
    }


    public void typeTab(Table dw, int timeout, int rowNum, String columnName) throws GeneralLeanFtException {
        Log.info(getClass().getName() + " typeTab " + dw.getObjectName() + " started");
        dw.waitUntilExists(timeout);
        typeData(dw, timeout, rowNum, columnName, Keys.TAB);
    }

    public void typeData(Table dw, int timeout, int rowNum, String columnName, String data) throws GeneralLeanFtException {

        dw.waitUntilEnabled(timeout);
        dw.selectCell(rowNum, columnName);
        Log.info(" sendKeys " + dw.getObjectName() + " " + data + " started");
        dw.sendKeys(data);
    }


    public  void typeData(EditField pbEdit, int timeout, String data) throws GeneralLeanFtException {
        Log.info(" typeData pbEdit " + pbEdit.getObjectName() + " started with data: " + data);
        pbEdit.waitUntilEnabled(timeout);
        pbEdit.setText(data);
    }

    public void setData(Table dw, int timeout, int rowNum, String columnName, String data) throws GeneralLeanFtException {
        Log.info(getClass().getName() + " setData " + dw.getObjectName() + " started with data: " + data);
        dw.waitUntilEnabled(timeout);
        dw.getCell(rowNum, columnName).setValue(data);
    }

    public  void click(Table dw, int timeout) throws GeneralLeanFtException {
        Log.info(" click " + dw.getObjectName() + " started");
        dw.waitUntilEnabled(timeout);
        dw.click();
    }

    public void activateCell(Table dw, int timeout, int rowNum, String columnName) throws GeneralLeanFtException {
        Log.info(getClass().getName() + " activateCell " + dw.getObjectName() + " started");
        dw.waitUntilEnabled(timeout);
        dw.activateCell(rowNum, columnName);
    }


    public int getRowCount(Table dw, int timeout) throws GeneralLeanFtException {
        Log.info(getClass().getName() + " getRowCount " + dw.getObjectName() + " started");
        dw.waitUntilEnabled(timeout);
        return dw.getRowCount();

    }


    public String getData(Table dw, int timeout, int rowNum, String columnName) throws GeneralLeanFtException {
        Log.info(getClass().getName() + " getConfigData " + dw.getObjectName() + " started "+columnName);
        dw.waitUntilEnabled(timeout);
        return dw.getCell(rowNum, columnName).getValue();
    }

    public  void click(Button btn, int timeout) throws GeneralLeanFtException {
        btn.waitUntilEnabled(timeout);
        btn.click();
    }

    public  void selectMenuItem(Menu menu, int timeout, String menuItem) throws GeneralLeanFtException {
        menu.waitUntilExists(timeout);
        menu.getItem(menuItem).isEnabled();
        menu.select(menuItem);
    }

}


