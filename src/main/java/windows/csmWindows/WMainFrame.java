package windows.csmWindows;
import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.RegExpProperty;
import com.hp.lft.sdk.powerbuilder.UiObject;
import com.hp.lft.sdk.powerbuilder.UiObjectDescription;
import com.hp.lft.sdk.powerbuilder.WindowDescription;
import com.hp.lft.sdk.stdwin.Menu;
import com.hp.lft.sdk.stdwin.MenuDescription;
import com.hp.lft.sdk.stdwin.Window;
//import com.hp.lft.sdk.stdwin.WindowDescription;


public class WMainFrame extends UiActions {

    int timeout = 20;
    Menu menu;
    protected UiObject sideMenuBar;

    public WMainFrame() throws GeneralLeanFtException {
        buildPageObject(winDescList);
        try {
            menu = Desktop.describe(Window.class, new com.hp.lft.sdk.stdwin.WindowDescription.Builder()
                    .childWindow(false)
                    .ownedWindow(false)
                    .windowTitleRegExp(new RegExpProperty(".*שירות לקוחות.*")).build())
                    .describe(Menu.class, new MenuDescription.Builder()
                            .type(com.hp.lft.sdk.stdwin.MenuType.MENU).build());
        } catch (GeneralLeanFtException e) {
            e.printStackTrace();
        }

        sideMenuBar = Desktop.describe(Window.class, new WindowDescription.Builder()
             //   .nativeClass("FNWND3125")
                .objectName("w_main_frame")
                .windowTitleRegExp(new RegExpProperty(".*שירות לקוחות.*")).build())
                .describe(UiObject.class, new UiObjectDescription.Builder()
                        .index(1)
                        .nativeClass("FNFIXEDBAR125")
                        .windowId(0).build());
    }

    public WSearchBan getSearchBanWin() throws GeneralLeanFtException {
        selectMenuItem(menu, timeout, "נושאים;כניסה למערכת;תיקיית לקוח\tF6");
        return new WSearchBan();
    }

    public WSearchBan getChargeCreationWin() throws GeneralLeanFtException {
        selectMenuItem(menu, timeout, "פעולות;קבלת תשלום");
        //******
        return new WSearchBan();
    }
    public WSearchBan getInitialCreditHistoryWin() throws GeneralLeanFtException {
        selectMenuItem(menu, timeout, "<Item 2>;<Item 4>");
        //******
        return new WSearchBan();
    }
    public WSearchBan getSearchLeadBanWin() throws GeneralLeanFtException {
        selectMenuItem(menu, timeout, "נושאים;הקמת לקוח פוטנציאלי\tF3");
        //******
        return new WSearchBan();
    }

    public WSearchBan getSearchBanWindowForCollection() throws GeneralLeanFtException {
        selectMenuItem(menu, timeout, "נושאים;כניסה למערכת;תיקיית ניהול גביה\tF10");
        //******
        return new WSearchBan();
    }

    public WSearchBan getRegisterWin() throws GeneralLeanFtException {
        selectMenuItem(menu, timeout, "נושאים;קופה");
        //******
        return new WSearchBan();
    }

    public WSearchBan getNewContractAgreementWin() throws GeneralLeanFtException {
        selectMenuItem(menu, timeout, "נושאים;כניסה למערכת;הסכם חדש\tF5");
        //******
        return new WSearchBan();
    }
    public WSearchBan getRmsQryParametersWin() throws GeneralLeanFtException {
        selectMenuItem(menu, timeout, "נושאים;היסטוריית חשבוניות ציוד");
        //******
        return new WSearchBan();
    }

    public WSearchBan getServiceCombListWin() throws GeneralLeanFtException {
        selectMenuItem(menu, timeout, "נושאים;צירופי שירותים");
        //******
        return new WSearchBan();
    }


    public WSearchBan getSearchCorporateWin() throws GeneralLeanFtException {
        selectMenuItem(menu, timeout, "נושאים;תאגיד;תאגיד\tF12");
        //******
        return new WSearchBan();
    }


    public void logOut() throws GeneralLeanFtException {
        selectMenuItem(menu, timeout, "קובץ;יציאה\tAlt+F4");
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






