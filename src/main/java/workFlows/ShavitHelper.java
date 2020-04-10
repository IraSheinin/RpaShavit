package workFlows;

import com.hp.lft.sdk.GeneralLeanFtException;
import utilities.ApplicationManager;
import utilities.exceptions.FinishedInTheMiddleException;
import helpers.shavitHelpers.Subscriber;
import windows.csmWindows.*;
import windows.sharedWindows.*;

public abstract class ShavitHelper extends DataTblIteration {
    private WLgMainFrame wLgMainFrame;
    protected WMainFrame wMainFrame;
    private WMessageBox msgBox;
    private WMaofTask wMaofTask;
    private WMessageBox msgBoxMdi;
    private WMessageBoxLg msgBoxLg;
    protected WSearchBan wSearchBan;
    protected WDealerSelect wDealerSelect;
    protected WBan wBan;
    WLgLogin wLgLogin;
    private String userName;
    private String password;

    public ShavitHelper(ApplicationManager appManager) throws GeneralLeanFtException {
        super(appManager);
        appManager.invokeApplication().getRunProcess();
        wMainFrame = new WMainFrame();
        msgBoxMdi = new WMessageBox("w_mdi_clock");
        wMaofTask = new WMaofTask();
        msgBox = new WMessageBox();
        msgBoxLg = new WMessageBoxLg();
        wLgMainFrame = new WLgMainFrame();
        wLgLogin = new WLgLogin();
        wDealerSelect = new WDealerSelect();
        wBan = new WBan();
        this.userName = appManager.getUserName();
        this.password = appManager.getPassword();
    }

    @Override
    protected void runTheFlow() throws GeneralLeanFtException, FinishedInTheMiddleException, InterruptedException {
    }

    public void act_GoToCsm() throws GeneralLeanFtException {
        wLgMainFrame = wLgLogin.login(userName, password, "");
        wLgMainFrame.goToCsm();
        msgBoxMdi.approve();
        wMaofTask.winExist(30);
    }

    private void getSearchBanWindow() throws GeneralLeanFtException {
        wSearchBan = wMainFrame.getSearchBanWin();
    }

    protected void act_GetBanFolderByCustomer(int rowNumExcel) throws GeneralLeanFtException {
        getSearchBanWindow();
        //Subscriber subNumber = new Subscriber(dataValues.get(0));
        String customerNum = getExceldataValues().get(rowNumExcel-1);
        wBan = wSearchBan.getBanWindow(customerNum);
        if (wDealerSelect.winExist(10)) {
            wDealerSelect.approve();
        }
    }

    protected void act_GetBanFolderBySubscriber(int rowNumExcel) throws GeneralLeanFtException {
        getSearchBanWindow();
        Subscriber subNumber = new Subscriber(getExceldataValues().get(rowNumExcel-1));
        wBan = wSearchBan.getBanWindow(subNumber);
        if (wDealerSelect.winExist(10)) {
            wDealerSelect.approve();
        }
    }

    public ShavitHelper act_LogOut() throws GeneralLeanFtException {
        wMainFrame.logOut();
        msgBox.approve();
        wLgMainFrame.logOut();
        msgBoxLg.approve();
        return this;
    }


    protected void act_CloseBanFolder() throws GeneralLeanFtException {
        wBan.closeWin(20);
        if (excelResultMsg.contentEquals("")) {
            excelResultMsg = "Pass";
        }
    }
     /*private void forceLogOut() throws GeneralLeanFtException {
         taskKill("RunTime.exe");//kill iglo process
         if (wMainFrame.winExist(2)){
             int id = wMainFrame.getWindowId();
             taskKill(String.valueOf(id));
         }
         if (wLgMainFrame.winExist(2)){
             int id = wLgMainFrame.getWindowId();
             taskKill(String.valueOf(id));
         }
         if (wLgLogin.winExist(2)){
             int id = wLgLogin.getWindowId();
             taskKill(String.valueOf(id));
         }
     }*/
}
