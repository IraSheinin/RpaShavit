package robots.masterProcessCreation;

import com.hp.lft.sdk.GeneralLeanFtException;
import utilities.ApplicationManager;
import utilities.exceptions.FinishedInTheMiddleException;

public class MasterProcessCreation_Flow extends MasterProcessCreation_Helper {

    public MasterProcessCreation_Flow(ApplicationManager appManager) throws GeneralLeanFtException {
        super(appManager);
    }

    @Override
    protected void runTheFlow() throws GeneralLeanFtException, FinishedInTheMiddleException {
        act_GetBanFolderByCustomer(0);

    }

}
