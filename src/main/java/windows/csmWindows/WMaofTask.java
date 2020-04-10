package windows.csmWindows;
import helpers.shavitHelpers.WinDesc;

public class WMaofTask extends UiActions {
    public WMaofTask() {
        WinDesc winDesc1 = new WinDesc();
        winDesc1.setName("w_maof_task");
        winDescList.add(1, winDesc1);
        buildPageObject(winDescList);
    }

}

