package robots.masterProcessCreation;
import com.hp.lft.sdk.GeneralLeanFtException;
import utilities.ApplicationManager;
import workFlows.TestBase;
import org.testng.annotations.Test;
import utilities.Log;


public class MasterProcessCreation extends TestBase {

    private MasterProcessCreation_Flow processHelper;

    @Test(enabled = true)
    public void start() throws GeneralLeanFtException, InterruptedException {
        Log.info("ApplicationManager.isMainLoopCompleted " + appManager.isMainLoopCompleted());
        while (!ApplicationManager.isMainLoopCompleted()) {
            processHelper = new MasterProcessCreation_Flow(appManager);
            processHelper.act_GoToCsm();
            processHelper.act_IterateThroughExcelData();
        }
        processHelper.act_LogOut();
    }
}
