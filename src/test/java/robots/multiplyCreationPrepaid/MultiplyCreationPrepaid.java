package robots.multiplyCreationPrepaid;
import com.hp.lft.sdk.GeneralLeanFtException;
import workFlows.TestBase;
import org.testng.annotations.Test;
import utilities.Log;


public class MultiplyCreationPrepaid extends TestBase {

    private MultiplyCreationPrepaid_Flow processHelper;

    @Test(enabled = true)
    public void start() throws GeneralLeanFtException, InterruptedException {
        Log.info("ApplicationManager.isMainLoopCompleted " + appManager.isMainLoopCompleted());
        while (!appManager.isMainLoopCompleted()) {
            processHelper = new MultiplyCreationPrepaid_Flow(appManager);
            processHelper.act_GoToCsm();
            processHelper.act_IterateThroughExcelData();
        }
        processHelper.act_LogOut();
    }
}
