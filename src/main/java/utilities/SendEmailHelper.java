package utilities;

public class SendEmailHelper {
    public SendEmailUtils getSendEmail() {
        return sendEmail;
    }

    private final SendEmailUtils sendEmail;

    public SendEmailHelper(ApplicationManager applicationManager){
        sendEmail = new SendEmailUtils(applicationManager.getEmailData());
    }


}
