package robots.masterProcessCreation;

import com.hp.lft.sdk.GeneralLeanFtException;
import utilities.ApplicationManager;
import utilities.exceptions.FinishedInTheMiddleException;
import workFlows.ShavitHelper;

abstract public class MasterProcessCreation_Helper extends ShavitHelper {

    public MasterProcessCreation_Helper(ApplicationManager appManager) throws GeneralLeanFtException {
        super(appManager);

    }


    @Override
    protected void runTheFlow() throws GeneralLeanFtException, FinishedInTheMiddleException {

    }


}
