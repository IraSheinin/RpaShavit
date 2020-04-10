package windows.csmWindows;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.Mouse;
import com.hp.lft.sdk.powerbuilder.Table;
import helpers.shavitHelpers.ObjDesc;
import helpers.shavitHelpers.WinDesc;

import java.awt.*;


public class WBan extends WMainFrame {

    Table dwWarning;

    public WBan() throws GeneralLeanFtException {
        super();
        //*************build this window **************************
        WinDesc winDesc1 = new WinDesc();
        winDesc1.setName("w_ban");
        winDescList.add(1, winDesc1);
        buildPageObject(winDescList);

        //*************window elements **************************
        dwWarning = pbObjectsBuilder.getDw(pbWin, new ObjDesc("dw_warning"));
    }

    public  WWaitActivationCtns selectWarningWaitActivation() throws GeneralLeanFtException {
        activateCell(dwWarning, 5, 0, "wait_activation");
        return new WWaitActivationCtns();
    }

    public WContractAgreement getContractAgreementWin() throws GeneralLeanFtException {
        Point p =  sideMenuBar.getLocation();
        p.y = p.y + 108;
        p.x = p.x +12;
        Mouse.click(p);


        //********************  מימוש!!!!!

        return new WContractAgreement();
    }


}

