package windows.csmWindows;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.powerbuilder.Button;
import helpers.shavitHelpers.ObjDesc;
import helpers.shavitHelpers.WinDesc;


public class WDealerSelect extends UiActions {
    Button btnApprove;

    public WDealerSelect() throws GeneralLeanFtException {
        //*************build this window **************************
        WinDesc winDesc1 = new WinDesc();
        winDesc1.setName("rw_dealer_select");
        winDescList.add(1, winDesc1);
        buildPageObject(winDescList);

        //*************window elements **************************
        btnApprove = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("cb_1"));

    }

    public void approve() throws GeneralLeanFtException {
        click(btnApprove, 10);
    }

}

