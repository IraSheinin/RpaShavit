package windows.sharedWindows;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.powerbuilder.Button;
import windows.csmWindows.UiActions;
import helpers.shavitHelpers.ObjDesc;
import helpers.shavitHelpers.WinDesc;

public class WMessageBox extends UiActions {
    Button okButton;
    public WMessageBox() throws GeneralLeanFtException {
        WinDesc winDesc1 = new WinDesc();
        winDesc1.setName("rw_message_box");
        winDescList.add(1, winDesc1);
        buildPageObject(winDescList);
        setOkButton();
    }

    private void setOkButton() throws GeneralLeanFtException {
        okButton = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("cb_1"));
    }

    public WMessageBox(String winName1) throws GeneralLeanFtException {
        WinDesc winDesc1 = new WinDesc();
        WinDesc winDesc2 = new WinDesc();
        winDesc1.setName(winName1);
        winDesc2.setName("rw_message_box");
        winDescList.add(1, winDesc1);
        winDescList.add(2, winDesc2);
        buildPageObject(winDescList);
        setOkButton();

    }
    public void approve() throws GeneralLeanFtException {
        int timeout = 40;
        click(okButton, timeout);
    }
}

