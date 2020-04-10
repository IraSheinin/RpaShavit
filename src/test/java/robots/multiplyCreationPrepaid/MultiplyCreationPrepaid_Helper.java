package robots.multiplyCreationPrepaid;

import com.hp.lft.sdk.GeneralLeanFtException;
import utilities.ApplicationManager;
import utilities.exceptions.FinishedInTheMiddleException;
import winDataStruct.ContractAgreement;
import windows.csmWindows.*;
import windows.sharedWindows.WMessageBox;
import workFlows.ShavitHelper;

import static utilities.ApplicationManager.pause;

abstract public class MultiplyCreationPrepaid_Helper extends ShavitHelper {

    private final WDeletedServices wDeletedServices;
    ContractAgreement cntAgrData;
    WContractAgreement wContractAgreement;
    WBanCtnWizard wBanCtnWizard;
    WMessageBox wMsgBox;

    String cmp1SocName = "עץ המבצעים;D2(פלאפון IZI);CMPPRP(מבצעי PREPAID);CMPPRPISR(ישראל PREPAID);CMPTLNG01(Talk&Go ספיישל בשבילך)";
    String cmp2SocName = "עץ המבצעים;S1(שרותי חסימה);CMP1PRNT(מעוניין/לא מעוניין בבקרת הורים);SNOPCONT(לא מעוניין בבקרת הורים)";
    String phoneNum = "0509089657";
    String amountToActivate = "200";


    public MultiplyCreationPrepaid_Helper(ApplicationManager appManager) throws GeneralLeanFtException {
        super(appManager);
        cntAgrData = new ContractAgreement();
        wBanCtnWizard = new WBanCtnWizard();
        wDeletedServices = new WDeletedServices();
        wMsgBox = new WMessageBox("rw_ban_ctn_wizard");
        cntAgrData.accoutType="";
        cntAgrData.applicationType = "ה.מקבצת למשווק";
        cntAgrData.banCtnLevel = "";
        cntAgrData.eqpSrc = "מלאי חברה";
        cntAgrData.agrCampaign = "";
        cntAgrData.preCampaignDesc = "מבצעי PREPAID";
    }

    protected void act_MakeNewAgreement() throws GeneralLeanFtException {
        cntAgrData.salesEntityCode = getExceldataValues().get(2-1);
        cntAgrData.branchCode = getExceldataValues().get(3-1);
        wContractAgreement = wBan.getContractAgreementWin();
        wContractAgreement.setContractData(cntAgrData);
        wContractAgreement.newAgreement();
        WExistingBanList wExistingBanList = new WExistingBanList();
        if (wExistingBanList.winExist(5)){
            wExistingBanList.addCtnToBanExist();
        }
    }

    protected void act_AddSocs() throws GeneralLeanFtException {
        wBanCtnWizard = new WBanCtnWizard();
        wBanCtnWizard.addSoc(cmp1SocName);
        wBanCtnWizard.addSoc(cmp2SocName);
    }
    protected void act_NextStep() throws GeneralLeanFtException {
        wBanCtnWizard.nextStep();

    }
    protected void act_CreatePhoneNumbers() throws GeneralLeanFtException, InterruptedException {
        wMsgBox.approve();
        wBanCtnWizard.setPhoneNumbers(amountToActivate, phoneNum);
    }
    protected void act_SaveSubscriber() throws GeneralLeanFtException, InterruptedException {
        wBanCtnWizard.saveSubscriber();
        pause(5000);
        if (wDeletedServices.winExist(5)){
            wDeletedServices.approve();
        }
        wMsgBox.approve();
        String orderNum = wBanCtnWizard.getOrderNum();
        excelResultMsg = orderNum;
        wBanCtnWizard.closeWin();
    }

    @Override
    protected void runTheFlow() throws GeneralLeanFtException, FinishedInTheMiddleException, InterruptedException {

    }


}
