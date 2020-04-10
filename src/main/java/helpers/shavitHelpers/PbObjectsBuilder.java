package helpers.shavitHelpers;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.powerbuilder.*;


public class PbObjectsBuilder {
    public Button getBtn(Window winPb, ObjDesc btnDesc) throws GeneralLeanFtException {
        Button btn = null;
        if (btnDesc.getText()==null ){
            btn = winPb.describe(Button.class, new ButtonDescription.Builder()
                    .objectName(btnDesc.getObjName()).build());

        }else{
            btn = winPb.describe(Button.class, new ButtonDescription.Builder()
                    .objectName(btnDesc.getObjName())
                    .text(btnDesc.getText())
                    .build());
        }
        return btn;
    }



    public Table getDw(Window winPb, ObjDesc dwDesc) throws GeneralLeanFtException {
        Table dw = null;

        if (dwDesc.getWindowId()==999  && dwDesc.getIndex()==999) {
            dw = winPb.describe(Table.class, new TableDescription.Builder()
                    .objectName(dwDesc.getObjName()).build());
        }
        if (dwDesc.getWindowId()!=999  && dwDesc.getIndex()==999) {
            dw = winPb.describe(Table.class, new TableDescription.Builder()
                    .objectName(dwDesc.getObjName())
                    .windowId(dwDesc.getWindowId())
                    .build());
        }
        if (dwDesc.getWindowId()!=999  && dwDesc.getIndex()!=999) {
            dw = winPb.describe(Table.class, new TableDescription.Builder()
                    .index(dwDesc.getIndex())
                    .objectName(dwDesc.getObjName())
                    .windowId(dwDesc.getWindowId())
                    .build());
        }
        return dw;
    }


    public EditField getPbEdit(Window winPb, ObjDesc ef) throws GeneralLeanFtException {
        EditField edit = null;
            edit = winPb.describe(EditField.class, new EditFieldDescription.Builder()
                    .objectName(ef.getObjName()).build());
        return edit;
    }

    public TabControl getTabControl(Window winPb, ObjDesc tcDesc) throws GeneralLeanFtException {
        TabControl tc = null;
            tc = winPb.describe(TabControl.class, new TabControlDescription.Builder()
                    .objectName(tcDesc.getObjName()).build());
        return tc;
    }

    public TreeView getTreeView(Window winPb, ObjDesc tvDesc) throws GeneralLeanFtException {
        TreeView tv = null;
            tv = winPb.describe(TreeView.class, new TreeViewDescription.Builder()
                    .objectName(tvDesc.getObjName()).build());
        return tv;
    }

}
