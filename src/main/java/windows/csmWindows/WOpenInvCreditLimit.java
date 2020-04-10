package windows.csmWindows;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.powerbuilder.Button;
import com.hp.lft.sdk.powerbuilder.Table;
import helpers.shavitHelpers.ObjDesc;
import helpers.shavitHelpers.WinDesc;


public class WOpenInvCreditLimit extends UiActions {
    private final Button btnCancel, btnSave;
    private final Table dw1;


    public WOpenInvCreditLimit() throws GeneralLeanFtException {
        //*************build this window **************************
        WinDesc winDesc1 = new WinDesc();
        winDesc1.setName("rw_open_inv_credit_limit");
        winDescList.add(1, winDesc1);
        buildPageObject(winDescList);

        //*************window elements **************************
        btnSave = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("cb_1"));
        btnCancel = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("cb_cancel"));
        dw1 = pbObjectsBuilder.getDw(pbWin, new ObjDesc("dw_1"));
    }


    public void setSpecialCreditLimit(String amount, String exprDate) throws GeneralLeanFtException {
        typeData(dw1, 1, 0, "special_credit_limit", amount);
        typeData(dw1, 1, 0, "exp_appr_date", exprDate);
        click(btnSave, 2);
    }

    public void getSpecialCreditLimit(String currentAmount) throws GeneralLeanFtException {
        currentAmount = getData(dw1, 1, 0, "special_credit_limit");

    }
    public void closeWin() throws GeneralLeanFtException {
        click(btnCancel, 10);
    }

}

