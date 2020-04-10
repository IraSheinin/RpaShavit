package windows.sharedWindows;
import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.RegExpProperty;
import com.hp.lft.sdk.stdwin.Menu;
import com.hp.lft.sdk.stdwin.MenuDescription;
import com.hp.lft.sdk.stdwin.Window;
import com.hp.lft.sdk.stdwin.WindowDescription;
import windows.csmWindows.UiActions;
import helpers.shavitHelpers.WinDesc;

public class WLgMainFrame extends UiActions {
    int timeout = 20;
    Menu menu;
    public WLgMainFrame() {
        WinDesc winDesc0 = new WinDesc();
        winDesc0.setName("w_lg_main_frame");
        winDescList.add(0, winDesc0);
        buildPageObject(winDescList);
        try {
             menu = Desktop.describe(Window.class, new WindowDescription.Builder()
                    .windowTitleRegExp(new RegExpProperty(".*Login.*"))
                    .build())
                    .describe(Menu.class, new MenuDescription.Builder()
                            .type(com.hp.lft.sdk.stdwin.MenuType.MENU).build());
        } catch (GeneralLeanFtException e) {
            e.printStackTrace();
        }
    }

    public void logOut() throws GeneralLeanFtException {
        selectMenuItem(menu, timeout, "קובץ;יציאה");
    }

    public void goToCsm() throws GeneralLeanFtException {
        selectMenuItem(menu, timeout, "יישומים;שירות לקוחות");
    }
}

/*

        Menu menu = null;
        try {
            menu = Desktop.describe(Window.class, new WindowDescription.Builder()
                    .childWindow(false)
                    .ownedWindow(false)
                    .windowClassRegExp("FNWND3125")
                    .windowTitleRegExp("Login  (V 179)").build())
                    .describe(Menu.class, new MenuDescription.Builder()
                            .type(com.hp.lft.sdk.stdwin.MenuType.MENU).build());
        } catch (GeneralLeanFtException e) {
            e.printStackTrace();
        }

        try {
            menu.exists(20);
        } catch (GeneralLeanFtException e) {
            e.printStackTrace();
        }
        try {
            menu.select("קובץ;יציאה");
        } catch (GeneralLeanFtException e) {
            e.printStackTrace();
        }
*/

/*        try {
             button1 = Desktop.describe(Window.class, new WindowDescription.Builder()
                    .nativeClass("FNWND3125")
                    .objectName("w_lg_main_frame")
                    .windowTitleRegExp("Login  (V 179)").build())
                    .describe(Window.class, new WindowDescription.Builder()
                            .nativeClass("FNWNS3125")
                            .objectName("rw_message_box")
                            .build())
                    .describe(Button.class, new ButtonDescription.Builder()
                            .nativeClass("Button")
                            .objectName("cb_1").build());

        } catch (GeneralLeanFtException e) {
            e.printStackTrace();
        }

        try {
            button1.exists(20);
        } catch (GeneralLeanFtException e) {
            e.printStackTrace();
        }
        try {
            button1.click();
        } catch (GeneralLeanFtException e) {
            e.printStackTrace();
        }*/






