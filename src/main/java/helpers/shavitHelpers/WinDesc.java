package helpers.shavitHelpers;

public class WinDesc {
    private  String name;
    private String titleRegExp;

    public void setName(String name ){
        this.name = name;
    }

    public void setTitleRegExp(String titleRegExp) {
        this.titleRegExp = titleRegExp;
    }
    public String getName() {
        return name;
    }
    public String getTitleRegExp() {
        return titleRegExp;
    }

}
