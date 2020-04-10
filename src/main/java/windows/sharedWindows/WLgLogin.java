package windows.sharedWindows;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.powerbuilder.*;
import windows.csmWindows.UiActions;
import helpers.shavitHelpers.ObjDesc;
import helpers.shavitHelpers.WinDesc;

import static utilities.ApplicationManager.taskKill;

public class WLgLogin extends UiActions {

    Table dw1Table;
    Button okButton;

    public WLgLogin() throws GeneralLeanFtException {
        WinDesc winDesc0 = new WinDesc();
        winDesc0.setName("w_lg_login");
        winDescList.remove(0);
        winDescList.add(0, winDesc0);
        buildPageObject(winDescList);
        okButton = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("cb_ok"));
        dw1Table = pbObjectsBuilder.getDw(pbWin, new ObjDesc("dw_1"));
    }

    public WLgMainFrame login(String userName, String password, String env) throws GeneralLeanFtException {
        int timeout = 20;
        typeData(dw1Table, timeout, 0, "user_id", userName);
        taskKill("RunTime.exe");//kill iglo process
        typeData(dw1Table, 1, 0, "password", password);
        typeTab(dw1Table, 1, 0, "password");
        click(okButton, 5);
       return new WLgMainFrame();
    }
}

