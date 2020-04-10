package robots.multiplyCreationPrepaid;
import com.hp.lft.sdk.GeneralLeanFtException;
import utilities.ApplicationManager;


public class MultiplyCreationPrepaid_Flow extends MultiplyCreationPrepaid_Helper {

    public MultiplyCreationPrepaid_Flow(ApplicationManager appManager) throws GeneralLeanFtException {
        super(appManager);
    }

    @Override
    protected void runTheFlow() throws GeneralLeanFtException, InterruptedException {
        act_GetBanFolderByCustomer(1);
        act_MakeNewAgreement();
        act_AddSocs();
        act_NextStep();
        act_NextStep();
        act_CreatePhoneNumbers();
        act_SaveSubscriber();
        act_CloseBanFolder();
    }

}
