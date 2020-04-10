package windows.csmWindows;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.powerbuilder.Button;
import helpers.shavitHelpers.ObjDesc;
import helpers.shavitHelpers.WinDesc;


public class WExistingBanList extends UiActions {
    Button btnAdd;

    public WExistingBanList() throws GeneralLeanFtException {
        //*************build this window **************************
        WinDesc winDesc1 = new WinDesc();
        winDesc1.setName("rw_existing_ban_list");
        winDescList.add(1, winDesc1);
        buildPageObject(winDescList);

        //*************window elements **************************
        btnAdd = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("cb_add_ctn_to_ban_exist"));

    }

    public void addCtnToBanExist() throws GeneralLeanFtException {
        click(btnAdd, 10);
    }

}

