package helpers.shavitHelpers;

public class ObjDesc {
    private  String objectName;
    private int index;
    private int windowId;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    private String text;

    public int getWindowId() {
        return windowId;
    }

    public void setWindowId(int windowId) {
        this.windowId = windowId;
    }


    public int getIndex() {
        return index;
    }
    public ObjDesc(String objectName ){
        this.index = 999;
        this.windowId = 999;
        this.objectName = objectName;

    }
    public String getObjName() {
        return objectName;
    }

    public void setIndex(int index){
        this.index = index;
    }

}
