package robots.multiplyActivationPrepaid;
import com.hp.lft.sdk.GeneralLeanFtException;
import utilities.ApplicationManager;
import utilities.exceptions.FinishedInTheMiddleException;


public class MultiplyActivationPrepaid_Flow extends MultiplyActivationPrepaid_Helper {
    public MultiplyActivationPrepaid_Flow(ApplicationManager appManager) throws GeneralLeanFtException {
        super(appManager);
    }

    @Override
    protected void runTheFlow() throws GeneralLeanFtException, FinishedInTheMiddleException, InterruptedException {
                act_GetBanFolderByCustomer(1);
                act_GetCtnsForActivation();
                act_ActivateAllCtns();
                act_CloseBanFolder();
    }
}
