package helpers.shavitHelpers;
import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.powerbuilder.*;
import helpers.shavitHelpers.WinDesc;

import java.util.List;

public class PbWindowBuilder {
    private Window pbWin;
    public Window getPbWin(List<WinDesc> winDesc){
        switch (winDesc.size()-1) {
            case 0:
                try {
                    pbWin = Desktop.describe(Window.class, new WindowDescription.Builder()
                            .objectName(winDesc.get(0).getName()).build());
                } catch (GeneralLeanFtException e) {
                    e.printStackTrace();
                }
                break;

            case 1:
                try {
                    pbWin = Desktop.describe(Window.class, new WindowDescription.Builder()
                            .objectName(winDesc.get(0).getName()).build())
                            .describe(Window.class, new WindowDescription.Builder()
                            .objectName(winDesc.get(1).getName()).build());
                } catch (GeneralLeanFtException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    pbWin = Desktop.describe(Window.class, new WindowDescription.Builder()
                            .objectName(winDesc.get(0).getName()).build())
                            .describe(Window.class, new WindowDescription.Builder()
                                    .objectName(winDesc.get(1).getName()).build())
                            .describe(Window.class, new WindowDescription.Builder()
                                    .objectName(winDesc.get(2).getName()).build());
                } catch (GeneralLeanFtException e) {
                    e.printStackTrace();
                }
                break;
        }
        return pbWin;
    }

}
