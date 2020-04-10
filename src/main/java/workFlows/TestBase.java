package workFlows;
import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ApplicationManager;
import utilities.Log;

public class TestBase {
    protected static ApplicationManager appManager;

    @BeforeMethod
    public void startSession(){
       PropertyConfigurator.configure("./configuration/Log4j2.properties");
       ModifiableSDKConfiguration config = null;
        try {
            config = new ModifiableSDKConfiguration();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            config.setServerAddress(new URI("ws://localhost:5095"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            SDK.init(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
        appManager = ApplicationManager.getInstance();
        appManager.setTestName(getClass().getSimpleName());
        appManager.loadDataFromConfigFile();
        Log.info("Test Base: startSession "+ getClass().getSimpleName());
        }

    @AfterMethod
    public void closeSession(){
        appManager = null;
    }

}
