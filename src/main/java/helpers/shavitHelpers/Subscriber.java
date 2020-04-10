package helpers.shavitHelpers;

public class Subscriber {
    private String subNumber;
    public Subscriber(String subNumber) {
        if (subNumber.startsWith("0")) {
            this.subNumber = subNumber;
        } else {
            this.subNumber = "0" + subNumber;
        }
    }
    public String getSubNumber() {
        return subNumber;
    }
}