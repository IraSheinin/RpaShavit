package windows.csmWindows;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.powerbuilder.*;
import helpers.shavitHelpers.ObjDesc;
import helpers.shavitHelpers.WinDesc;

import static utilities.ApplicationManager.pause;

public class WBanCtnWizard extends UiActions {
    private final Button btnOk;
    private final Button btnRedPhone;
    private final Button btnSelect, btnNext;
    private final Table dwCtnTtnCount;
    private final Table dwUnit0;
    private final Table dwUnit1;
    private final Button btnSaveSub;
    private final Button btnClose;

    TreeView tv1TreeView;

    public WBanCtnWizard() throws GeneralLeanFtException {
        //*************build this window **************************
        WinDesc winDesc1 = new WinDesc();
        winDesc1.setName("rw_ban_ctn_wizard");
        winDescList.add(1, winDesc1);
        buildPageObject(winDescList);

        //*************window elements **************************
        dwCtnTtnCount = pbObjectsBuilder.getDw(pbWin, new ObjDesc("dw_ctn_ttn_count"));

        ObjDesc dwUnit0Desc = new ObjDesc("dw_unit");
        dwUnit0Desc.setIndex(0);
        dwUnit0Desc.setWindowId(1000);
        dwUnit0 = pbObjectsBuilder.getDw(pbWin, dwUnit0Desc);

        ObjDesc dwUnit1Desc = new ObjDesc("dw_unit");
        dwUnit1Desc.setIndex(1);
        dwUnit1Desc.setWindowId(1000);
        dwUnit1 = pbObjectsBuilder.getDw(pbWin, dwUnit1Desc);

        btnSelect = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("cb_select"));
        btnNext = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("cb_next"));
        btnOk = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("cb_ok"));
        btnRedPhone = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("pb_1"));
        tv1TreeView = pbObjectsBuilder.getTreeView(pbWin, new ObjDesc("tv_1"));
        btnSaveSub = pbObjectsBuilder.getBtn(pbWin, new ObjDesc("cb_create"));

        ObjDesc btnCancelDesc = new ObjDesc("cb_cancel");
        btnCancelDesc.setText("סגור");
        btnClose = pbObjectsBuilder.getBtn(pbWin, btnCancelDesc);


    }


    public void setPhoneNumbers(String count, String phoneNum) throws GeneralLeanFtException, InterruptedException {
        setData(dwCtnTtnCount, 2, 0, "count", count);
        click(btnOk, 10);
        pause(7000);
        click(btnRedPhone, 30);
        pause(7000);
        setData(dwUnit0, 20, 0,  "data_protection", "פתוח לכל אמצעי התקשור");
        typeData(dwUnit1, 10, 0 , "sms_phone_no", phoneNum);
    }


    public void saveSubscriber() throws GeneralLeanFtException, InterruptedException {
        pause(1000);
        click(btnSaveSub, 20);
        pause(5000);
    }

    public void closeWin() throws GeneralLeanFtException, InterruptedException {
        pause(1000);
        click(btnClose, 30);
    }

    public String getOrderNum() throws GeneralLeanFtException {
       return pbWin.getWindowTitleRegExp().substring(12, 20);
    }

    public void addSoc(String socName) throws GeneralLeanFtException {
        selectSocFromTree(socName);
        click(btnSelect,5);
    }


    private void selectSocFromTree(String socName) throws GeneralLeanFtException {
        String[] socNameList;
        socNameList = socName.split(";");
        String help="";
        for (String s :socNameList) {
            TreeViewNode node = tv1TreeView.getNode(help+s);
            tv1TreeView.select(node);
            if (!node.isExpanded() ){
                node.expand();
            }
            help = help +s+";";
        }
    }




    public void nextStep() throws GeneralLeanFtException {
        click(btnNext, 10);

    }


}
