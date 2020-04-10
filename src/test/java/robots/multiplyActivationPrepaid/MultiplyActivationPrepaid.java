package robots.multiplyActivationPrepaid;
import com.hp.lft.sdk.*;
import utilities.ApplicationManager;
import workFlows.TestBase;
import org.testng.annotations.Test;
import utilities.Log;

public class MultiplyActivationPrepaid extends TestBase {

    private MultiplyActivationPrepaid_Flow processHelper;

    @Test(enabled = true)
    public void start() throws GeneralLeanFtException, InterruptedException {
        Log.info("ApplicationManager.isMainLoopCompleted " + appManager.isMainLoopCompleted());
        while (!ApplicationManager.isMainLoopCompleted()) {
            processHelper = new MultiplyActivationPrepaid_Flow(appManager);
            processHelper.act_GoToCsm();
            processHelper.act_IterateThroughExcelData();
        }
        processHelper.act_LogOut();
    }
}

