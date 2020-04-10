package utilities;

public class SendEmailData {
    private String mailSubject;
    private String mailMsg;
    private String mailFrom;

    private String attachmentPath;
    private String attachmentName;
    private String mailSendTo;
    private String hostName;
    private int smtpPort;

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public String getMailMsg() {
        return mailMsg;
    }

    public void setMailMsg(String mailMsg) {
        this.mailMsg = mailMsg;
    }

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    public String getMailSendTo() {
        return mailSendTo;
    }

    public void setMailSendTo(String mailSendTo) {
        this.mailSendTo = mailSendTo;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(int smtpPort) {
        this.smtpPort = smtpPort;
    }

}