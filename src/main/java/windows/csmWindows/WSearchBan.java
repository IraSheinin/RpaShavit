package windows.csmWindows;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.powerbuilder.Button;
import com.hp.lft.sdk.powerbuilder.EditField;
import com.hp.lft.sdk.powerbuilder.Table;
import helpers.shavitHelpers.ObjDesc;
import helpers.shavitHelpers.Subscriber;
import helpers.shavitHelpers.WinDesc;

public class WSearchBan extends UiActions {
    private final EditField editCustomer;
    private final Table dwCtn;
    private final  Button btnGet, btnOk, btnCancel;
    public WSearchBan() throws GeneralLeanFtException {
        //*************build this window **************************
        WinDesc winDesc1 = new WinDesc();
        winDesc1.setName("rw_search_ban");
        winDescList.add(1, winDesc1);
        buildPageObject(winDescList);

        //*************window elements **************************
        dwCtn = pbObjectsBuilder.getDw(pbWin, new ObjDesc("dw_ctn"));
        btnGet = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("cb_get"));
        btnOk = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("cb_ok"));
        btnCancel = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("cb_cancel"));
        editCustomer = pbObjectsBuilder.getPbEdit(pbWin, new ObjDesc("em_last"));
    }
    private void setSubNumber(String subNumber) throws GeneralLeanFtException {
        typeData(dwCtn, 20, 0, "subscriber_no", subNumber);
    }
    public WBan getBanWindow(Subscriber subNumber) throws GeneralLeanFtException {
        setSubNumber(subNumber.getSubNumber());
        get();
        ok();
        return new WBan();
    }

    public WBan getBanWindow(String customerId) throws GeneralLeanFtException {
        setBanNumber(customerId);
        get();
        return new WBan();
    }

    private void setBanNumber(String customerId) throws GeneralLeanFtException {
        typeData(editCustomer, 20, customerId);
    }
     void get() throws GeneralLeanFtException {
        click(btnGet, 10);
    }
    void ok() throws GeneralLeanFtException {
        click(btnOk, 10);
    }
}

