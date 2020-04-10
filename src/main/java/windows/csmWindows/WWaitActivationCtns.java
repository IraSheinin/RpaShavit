package windows.csmWindows;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.powerbuilder.Button;
import com.hp.lft.sdk.powerbuilder.Table;
import utilities.exceptions.FinishedInTheMiddleException;
import helpers.shavitHelpers.ObjDesc;
import helpers.shavitHelpers.WinDesc;
import windows.sharedWindows.WMessageBox;


public class WWaitActivationCtns extends UiActions {
    Button btnActivation, btnSelectAll, btnClose;
    Table dwTitle, dwAgreementList, dwCtnList;
    String winName = "rw_wait_activation_ctns";

    public WWaitActivationCtns() throws GeneralLeanFtException {
        //*************build this window **************************
        WinDesc winDesc1 = new WinDesc();
        winDesc1.setName(winName);
        winDescList.add(1, winDesc1);
        buildPageObject(winDescList);

        //*************window elements **************************
        btnActivation = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("cb_activation"));
        btnSelectAll = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("cb_select_all"));
        btnClose = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("cb_close"));

        dwTitle = pbObjectsBuilder.getDw(pbWin, new ObjDesc("dw_title"));
        dwCtnList = pbObjectsBuilder.getDw(pbWin, new ObjDesc("dw_ctn_list"));
        dwAgreementList = pbObjectsBuilder.getDw(pbWin, new ObjDesc("dw_agreement_list"));

    }

    public void selectSubType(String numberType) throws GeneralLeanFtException, FinishedInTheMiddleException {
        setData(dwTitle, 5, 0, "number_type", numberType);
        String actualNumberType = getData(dwTitle, 5, 0, "number_type");
        if (numberType.equals(actualNumberType)){

        }
        else{
            throw new FinishedInTheMiddleException("Can't select: "+numberType+" Actual selection: "+actualNumberType);
        }
    }
    public int getTotalAmount() throws GeneralLeanFtException {
        return getRowCount(dwAgreementList, 5);
    }

    public void selectAll() throws GeneralLeanFtException {
        click(btnSelectAll, 3);
    }

    public void activate() throws GeneralLeanFtException {
        WMessageBox msgBox = new WMessageBox(winName);
        click(btnActivation, 3);
        msgBox.approve();

    }
    public void closeWin() throws GeneralLeanFtException {
        click(btnClose,2);
    }

}

