package robots.testForSingleAction;

import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.net.URI;
import java.net.URISyntaxException;

public class BaseSingleAction {
    private static ProcessBuilder winApplication=null;

    @BeforeClass
    public void startSession(){
        String platform = "windows";
        switch (platform){
            case "windows":
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
                break;
            case "web":
                break;
            default:
                System.out.printf("startSession Error");
        }
    }

    @AfterClass
    public void closeSession(){


    }

}
