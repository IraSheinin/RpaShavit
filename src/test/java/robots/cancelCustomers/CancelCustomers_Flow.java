package robots.cancelCustomers;

import com.hp.lft.sdk.GeneralLeanFtException;
import utilities.ApplicationManager;
import utilities.exceptions.FinishedInTheMiddleException;

public class CancelCustomers_Flow extends CancelCustomers_Helper {

    public CancelCustomers_Flow(ApplicationManager appManager) throws GeneralLeanFtException {
        super(appManager);
    }

    @Override
    protected void runTheFlow() throws GeneralLeanFtException, FinishedInTheMiddleException {
        act_GetBanFolderByCustomer(0);

    }

}
