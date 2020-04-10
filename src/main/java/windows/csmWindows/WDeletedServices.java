package windows.csmWindows;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.powerbuilder.Button;
import helpers.shavitHelpers.ObjDesc;
import helpers.shavitHelpers.WinDesc;


public class WDeletedServices extends UiActions {
    Button btnOk;

    public WDeletedServices() throws GeneralLeanFtException {
        //*************build this window **************************
        WinDesc winDesc1 = new WinDesc();
        winDesc1.setName("rw_deleted_services");
        winDescList.add(1, winDesc1);
        buildPageObject(winDescList);
        //*************window elements **************************
        btnOk = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("cb_ok"));

    }

    public void approve() throws GeneralLeanFtException {
        click(btnOk, 10);
    }

}

