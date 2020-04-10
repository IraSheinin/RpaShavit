package windows.csmWindows;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.powerbuilder.Button;
import com.hp.lft.sdk.powerbuilder.Table;
import helpers.shavitHelpers.ObjDesc;
import helpers.shavitHelpers.WinDesc;


public class WChangeCreditResult extends UiActions {
    private final Button btnCancel, btnOk, btnAdd;
    private final Table dw1, dw2;

    public WChangeCreditResult() throws GeneralLeanFtException {
        //*************build this window **************************
        WinDesc winDesc1 = new WinDesc();
        winDesc1.setName("rw_initial_credit_history");
        winDescList.add(1, winDesc1);
        buildPageObject(winDescList);

        //*************window elements **************************
        btnOk = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("cb_ok"));
        btnAdd = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("shl_1"));
        btnCancel = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("cb_cancel"));

        dw1 = pbObjectsBuilder.getDw(pbWin, new ObjDesc("dw_1"));
        dw2 = pbObjectsBuilder.getDw(pbWin, new ObjDesc("dw_2"));
    }

    public void addSpecialCreditAmount(String amount, String exprDate) throws GeneralLeanFtException {
        WOpenInvCreditLimit wOpenInvCreditLimit = new  WOpenInvCreditLimit();
        click(btnAdd, 2);
        wOpenInvCreditLimit.setSpecialCreditLimit(amount, exprDate);
        click(btnOk,1);
    }

    public void closeWin() throws GeneralLeanFtException {
        click(btnCancel, 5);
    }

}

