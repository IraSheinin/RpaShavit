package robots.cancelCustomers;

import com.hp.lft.sdk.GeneralLeanFtException;
import org.testng.annotations.Test;
import utilities.ApplicationManager;
import utilities.Log;
import workFlows.TestBase;


public class CancelCustomers extends TestBase {

    private CancelCustomers_Flow processHelper;

    @Test(enabled = true)
    public void start() throws GeneralLeanFtException, InterruptedException {
        Log.info("ApplicationManager.isMainLoopCompleted " + appManager.isMainLoopCompleted());
        while (!ApplicationManager.isMainLoopCompleted()) {
            processHelper = new CancelCustomers_Flow(appManager);
            processHelper.act_GoToCsm();
            processHelper.act_IterateThroughExcelData();
        }
        processHelper.act_LogOut();
    }
}
