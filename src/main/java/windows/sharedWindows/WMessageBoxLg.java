package windows.sharedWindows;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.powerbuilder.Button;
import windows.csmWindows.UiActions;
import helpers.shavitHelpers.ObjDesc;
import helpers.shavitHelpers.WinDesc;

public class WMessageBoxLg extends UiActions {
    Button okButton;
    public WMessageBoxLg() throws GeneralLeanFtException {
        WinDesc winDesc0 = new WinDesc();
        WinDesc winDesc1 = new WinDesc();
        winDesc0.setName("w_lg_main_frame");
        winDesc1.setName("rw_message_box");
        winDescList.remove(0);
        winDescList.add(0, winDesc0);
        winDescList.add(1, winDesc1);
        buildPageObject(winDescList);
        okButton = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("cb_1"));
    }

    public void approve() throws GeneralLeanFtException {
        int timeout = 40;
        click(okButton, timeout);

    }
}

