package robots.multiplyActivationPrepaid;
import com.hp.lft.sdk.GeneralLeanFtException;
import utilities.ApplicationManager;
import utilities.exceptions.FinishedInTheMiddleException;
import utilities.Log;
import windows.csmWindows.WWaitActivationCtns;
import workFlows.ShavitHelper;

import static utilities.ApplicationManager.pause;

abstract public class MultiplyActivationPrepaid_Helper extends ShavitHelper {
    WWaitActivationCtns wWaitActivationCtns;

    public MultiplyActivationPrepaid_Helper(ApplicationManager appManager) throws GeneralLeanFtException {
        super(appManager);
    }

    protected void act_GetCtnsForActivation() throws FinishedInTheMiddleException, GeneralLeanFtException {
        try {
            wWaitActivationCtns = wBan.selectWarningWaitActivation();
        }catch(GeneralLeanFtException e){
            excelResultMsg = "אין מנויים לאיקטוב";
            wBan.closeWin(5);
            throw new FinishedInTheMiddleException("Go to tne next row");
        }

        try {
            wWaitActivationCtns.selectSubType("מנויים ממקבצת");
        } catch (GeneralLeanFtException e) {
            excelResultMsg ="אין מנויים ממקבצת";
            wWaitActivationCtns.closeWin(5);
            wBan.closeWin(5);
            throw new FinishedInTheMiddleException("Go to tne next row");
        }
    }

    protected void act_ActivateAllCtns() throws GeneralLeanFtException, InterruptedException {
        int amount = wWaitActivationCtns.getTotalAmount();
        Log.info("Amount for activation: "+amount);
        int i=0;
        try {
            for ( i = 0; i < amount; i++) {
                wWaitActivationCtns.selectAll();
                wWaitActivationCtns.activate();
                pause(500000);  //9 minutes
            }
        }catch (GeneralLeanFtException e){
            if (i<amount){
                appManager.insideLoopCompleted=false;// next try have to go to excel same row
                Log.error("Inside loop not ended");
                throw new GeneralLeanFtException("GeneralLeanFtException + internal loop not completed");
            }
        }
        wWaitActivationCtns.closeWin(5);
    }

    @Override
    protected void runTheFlow() throws GeneralLeanFtException, FinishedInTheMiddleException, InterruptedException {
    }
}
