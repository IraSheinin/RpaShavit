package windows.csmWindows;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.powerbuilder.Button;
import com.hp.lft.sdk.powerbuilder.Table;
import helpers.shavitHelpers.ObjDesc;
import helpers.shavitHelpers.WinDesc;
import windows.sharedWindows.WMessageBox;


public class WInitialCreditHistory extends UiActions {
    private final Button btnCancel;
    private final Table dw1, dw2;
    private final Button btnBDI, btnDisplay;

    public WInitialCreditHistory() throws GeneralLeanFtException {
        //*************build this window **************************
        WinDesc winDesc1 = new WinDesc();
        winDesc1.setName("rw_initial_credit_history");
        winDescList.add(1, winDesc1);
        buildPageObject(winDescList);

        //*************window elements **************************
        btnBDI = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("cb_bdi"));
        btnDisplay = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("cb_display"));
        btnCancel = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("cb_cancel"));

        dw1 = pbObjectsBuilder.getDw(pbWin, new ObjDesc("dw_1"));
        dw2 = pbObjectsBuilder.getDw(pbWin, new ObjDesc("dw_2"));

    }

    public void goToBDI(String id) throws GeneralLeanFtException {
        WMessageBox wMsgBox = new WMessageBox();
        typeData(dw1, 5, 0, "identity_number", id);
        click(btnDisplay, 5);
        click(btnBDI, 5);
        if(wMsgBox.winExist(5)){
            wMsgBox.approve();
        }

    }

    public void getLastStatus(String outStatus) throws GeneralLeanFtException {
        outStatus = getData(dw2,10, 1, "st_text");

    }

    public void closeWin() throws GeneralLeanFtException {
        click(btnCancel, 5);
    }

}

