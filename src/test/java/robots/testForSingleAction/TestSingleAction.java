package robots.testForSingleAction;

import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.powerbuilder.Window;
import com.hp.lft.sdk.powerbuilder.WindowDescription;
import org.testng.annotations.Test;

public class TestSingleAction extends BaseSingleAction {


    @Test(enabled = true)
    public void startTest() throws GeneralLeanFtException {



        Window rwBanCtnWizardWindow = Desktop.describe(Window.class, new WindowDescription.Builder()
            //    .nativeClass("FNWND3125")
                .objectName("w_main_frame")
                //.windowTitleRegExp("Xenrunner2 / שירות לקוחות / lref")
                .build())
                .describe(Window.class, new WindowDescription.Builder()
                  //      .nativeClass("FNWNS3125")
                        .objectName("rw_ban_ctn_wizard")
                       // .windowTitleRegExp("הסכם ה.מקבצת למשווק, שם לקוח: פלאפון טוק אנד גו פריפייד, מספר לקוח: 7247782, מקים ההסכם: ר. סגרון החלק הטוב בנתיבות בע\"-נאור עסיס")
                        .build());

      //  String[] title =  rwBanCtnWizardWindow.getWindowTitleRegExp().split("מספר ההסכם ");
      //  String[] orderNumber = title[0].split(",");


        String title =  rwBanCtnWizardWindow.getWindowTitleRegExp().substring(12, 20);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

/*

        PbObjectsBuilder objBuilder = new PbObjectsBuilder();
        Window win = Desktop.describe(Window.class, new WindowDescription.Builder()
                .objectName("w_main_frame")
                .build())
                .describe(Window.class, new WindowDescription.Builder()
                        //      .nativeClass("FNWNS3125")
                        .objectName("rw_ban_ctn_wizard")
                        .build());


        ObjDesc dwUnit0Desc = new ObjDesc("dw_unit");
        dwUnit0Desc.setIndex(0);
        dwUnit0Desc.setWindowId(1000);


        Table dwUnitTable = objBuilder.getDw(win, dwUnit0Desc);



        dwUnitTable.getCell(0, "data_protection").setValue("פתוח לכל אמצעי התקשור");
*/




/*
        Table dwUnitTable = Desktop.describe(Window.class, new WindowDescription.Builder()
               // .nativeClass("FNWND3125")
                .objectName("w_main_frame")
                //.windowTitleRegExp("Xenrunner2 / שירות לקוחות / lref")
                .build())
                .describe(Window.class, new WindowDescription.Builder()
                  //      .nativeClass("FNWNS3125")
                        .objectName("rw_ban_ctn_wizard")
                        //.windowTitleRegExp("הסכם ה.מקבצת למשווק, שם לקוח: פלאפון טוק אנד גו פריפייד, מספר לקוח: 7247782, מקים ההסכם: ר. סגרון החלק הטוב בנתיבות בע\"-נאור עסיס")
                        .build())
                .describe(Table.class, new TableDescription.Builder()
                        .index(0)
                   //     .nativeClass("pbdw125")
                        .objectName("dw_unit")
                        .windowId(1000).build());
*/









/*

        TreeView tv1TreeView;

         tv1TreeView = Desktop.describe(Window.class, new WindowDescription.Builder()
                //.nativeClass("FNWND3125")
                .objectName("w_main_frame")
                //.windowTitleRegExp("Xenrunner2 / שירות לקוחות / lref")
                .build())
                .describe(Window.class, new WindowDescription.Builder()
                    //    .nativeClass("FNWNS3125")
                        .objectName("rw_ban_ctn_wizard")
                  //      .windowTitleRegExp("הסכם ה.מקבצת למשווק, שם לקוח: פלאפון טוק אנד גו פריפייד, מספר לקוח: 7247782, מקים ההסכם: ר. סגרון החלק הטוב בנתיבות בע\"-נאור עסיס")
                        .build())
                .describe(TreeView.class, new TreeViewDescription.Builder()
                //        .nativeClass("PBTreeView32_100")
                        .objectName("tv_1").build());
*/


  //      tv1TreeView.select("עץ המבצעים;D2(פלאפון IZI)");



  //      tv1TreeView.select("עץ המבצעים;D2(פלאפון IZI);CMPPRP(מבצעי PREPAID)");
  //      tv1TreeView.select("עץ המבצעים;D2(פלאפון IZI);CMPPRP(מבצעי PREPAID);CMPPRPISR(ישראל PREPAID)");

/*

        String socToBeSelected1 = "עץ המבצעים;D2(פלאפון IZI);CMPPRP(מבצעי PREPAID);CMPPRPISR(ישראל PREPAID);CMPTLNG01(Talk&Go ספיישל בשבילך)";
        String[] socList1;
        socList1 = socToBeSelected1.split(";");
        String help="";
        for (String s :socList1) {
            TreeViewNode node = tv1TreeView.getNode(help+s);
            //tv1TreeView.select(help+s);
            tv1TreeView.select(node);
            if (!node.isExpanded() ){
                node.expand();
            }
            help = help +s+";";
        }
        String socToBeSelected2 ="עץ המבצעים;S1(שרותי חסימה);CMP1PRNT(מעוניין/לא מעוניין בבקרת הורים);SNOPCONT(לא מעוניין בבקרת הורים)";
        String[] socList2;
        socList2 = socToBeSelected2.split(";");
        String help2="";
        for (String s :socList2) {
            TreeViewNode node = tv1TreeView.getNode(help2+s);
            //tv1TreeView.select(help2+s);
            tv1TreeView.select(node);
            if (!node.isExpanded() ){
                node.expand();
            }
            help2 = help2 +s+";";
        }

*/




     //   tv1TreeView.select("עץ המבצעים;D2(פלאפון IZI);CMPPRP(מבצעי PREPAID);CMPPRPISR(ישראל PREPAID);CMPTLNG01(Talk&Go ספיישל בשבילך)");


/*
        Table dwSalesContractInfoTable = Desktop.describe(Window.class, new WindowDescription.Builder()
                //.nativeClass("FNWND3125")
                .objectName("w_main_frame")
                //.windowTitleRegExp("Xenrunner2 / שירות לקוחות / lref")
                .build())
                .describe(Window.class, new WindowDescription.Builder()
                  //     .nativeClass("FNWND3125")
                        .objectName("w_contract_agreement")
                        //.windowTitleRegExp("פרטי הסכם")
                        .build())
                .describe(Table.class, new TableDescription.Builder()
                        //.nativeClass("pbdw125")
                        .objectName("dw_sales_contract_info").build());

       dwSalesContractInfoTable.selectCell(0,"branch_code" );
        dwSalesContractInfoTable.sendKeys("201539996");
        dwSalesContractInfoTable.sendKeys(Keys.TAB);

      //  dwSalesContractInfoTable.getCell(0, "branch_code").setValue("201539996");

















        UiObject pbObjectUiObject = null;

        try {
            pbObjectUiObject = Desktop.describe(Window.class, new WindowDescription.Builder()
                   //.nativeClass("FNWND3125")
                   .objectName("w_main_frame")
                   //.windowTitleRegExp("Xenrunner2 / שירות לקוחות / lref")
                    .build())
                   .describe(UiObject.class, new UiObjectDescription.Builder()
                           .index(1)
                           .nativeClass("FNFIXEDBAR125")
                           .windowId(0).build());
        } catch (GeneralLeanFtException e) {
            e.printStackTrace();
        }

        ClickArgs clickArgs = new ClickArgs();
        Point p =  pbObjectUiObject.getLocation();

        p.y = p.y + 108;
        p.x = p.x +12;

        Mouse.click(p);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


*/


   /*     Point point = new Point();
        point.x = 12;
        point.y = 12;
        Location loc = new Location(BOTTOM_LEFT , point);
        sideMenuBar.click(new ClickArgs(MouseButton.LEFT,  loc));

*/




       /* Button button = null;
        try {
             button = Desktop.describe(Window.class, new WindowDescription.Builder()
                    .nativeClass("FNWND3125")
                    .objectName("w_main_frame")
                    .windowTitleRegExp("Xenrunner2 / שירות לקוחות / lref")
                     .build())
                    .describe(Window.class, new WindowDescription.Builder()
                            .nativeClass("FNWNS3125")
                            .objectName("rw_wait_activation_ctns")
                            .windowTitleRegExp("מנויים ממתינים לאקטוב ללקוח  7247777")
                            .build())

                    .describe(Window.class, new WindowDescription.Builder()
                            .nativeClass("FNWNS3125")
                            .objectName("rw_message_box")
                            .windowTitleRegExp("המשך את האקטיבציה (#6800054)").build())
                    .describe(Button.class, new ButtonDescription.Builder()
                            .nativeClass("Button")
                            .objectName("cb_2").build());
        } catch (GeneralLeanFtException e) {
            e.printStackTrace();
        }
        try {
            button.click();
        } catch (GeneralLeanFtException e) {
            e.printStackTrace();
        }*/
/*
        Button button=null;
        try {
             button = Desktop.describe(Window.class, new WindowDescription.Builder()
                    //.nativeClass("FNWND3125")
                    .objectName("w_main_frame")
                    //.windowTitleRegExp("Xenrunner2 / שירות לקוחות / lref")
                     .build())
                    .describe(Window.class, new WindowDescription.Builder()
                      //      .nativeClass("FNWNS3125")
                            .objectName("rw_wait_activation_ctns")
                            //.windowTitleRegExp("מנויים ממתינים לאקטוב ללקוח  7247777")
                            .build())
                    .describe(Button.class, new ButtonDescription.Builder()
                            .nativeClass("Button")
                            .objectName("cb_close").build());
        } catch (GeneralLeanFtException e) {
            e.printStackTrace();
        }
        try {
            button.click();
        } catch (GeneralLeanFtException e) {
            e.printStackTrace();
        }
*/


       /* TreeView tv1TreeView = null;
        try {
             tv1TreeView = Desktop.describe(Window.class, new WindowDescription.Builder()
                    .nativeClass("FNWND3125")
                    .objectName("w_main_frame")
                  //  .windowTitleRegExp("Xenrunner2 / שירות לקוחות / lref")
                    .build())
                    .describe(Window.class, new WindowDescription.Builder()
                            .nativeClass("FNWND3125")
                            .objectName("w_ban")
                           // .windowTitleRegExp(" 714076274")
                            .build())
                    .describe(TreeView.class, new TreeViewDescription.Builder()
                            .nativeClass("PBTreeView32_100")
                            .objectName("tv_1").build());
        } catch (GeneralLeanFtException e) {
            e.printStackTrace();
        }
        try {
            tv1TreeView.activateNode("עץ המבצעים;A1(פלאפון-פרטי);CMPGLBSM3(GLOBAL SIM Super Pharm)");
        } catch (GeneralLeanFtException e) {
            e.printStackTrace();
        }*/





     /*
        try {
            dwWarningTable.selectCell (1, "wait_activation");
        } catch (GeneralLeanFtException e) {
            e.printStackTrace();
        }
        try {
            dwWarningTable.click (1, "wait_activation");
        } catch (GeneralLeanFtException e) {
            e.printStackTrace();
        }
        try {
            dwWarningTable.click();
        } catch (GeneralLeanFtException e) {
            e.printStackTrace();
        }
        try {
            dwWarningTable.doubleClick();
        } catch (GeneralLeanFtException e) {
            e.printStackTrace();
        }*/
    }

  // Editor e;

   /* {
        try {
            e = Desktop.describe(Window.class, new WindowDescription.Builder()
                        //.nativeClass("FNWND3125")
                        .objectName("w_main_frame")
                        //.windowTitleRegExp("Xenrunner2 / שירות לקוחות / lref")
                        .build())
                        .describe(Window.class, new WindowDescription.Builder()
                                //.nativeClass("FNWNS3125")
                                .objectName("rw_wait_activation_ctns")
                                .windowTitleRegExp("מנויים ממתינים לאקטוב ללקוח  7247777")
                                .build())
                        .describe(Window.class, new WindowDescription.Builder()
                                //.nativeClass("FNWNS3125")
                                .objectName("rw_message_box")
                              //  .windowTitleRegExp("המשך את האקטיבציה (#6800054)")
                                .build())
                        .describe(Editor.class, new EditorDescription.Builder()
                                .nativeClass("Edit").build());
        } catch (GeneralLeanFtException e1) {
            e1.printStackTrace();
        }

        try {
            e.getText();

            e.getText();
        } catch (GeneralLeanFtException e1) {
            e1.printStackTrace();
        }
    }*/

}
