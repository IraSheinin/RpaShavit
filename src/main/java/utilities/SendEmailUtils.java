package utilities;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

import java.lang.reflect.Field;
import java.nio.charset.Charset;

public class SendEmailUtils {
    public SendEmailUtils(SendEmailData emailData) {
        System.setProperty("file.encoding", "UTF-8");
        Field charset = null;
        try {
            charset = Charset.class.getDeclaredField("defaultCharset");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        charset.setAccessible(true);
        try {
            charset.set(null,null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(emailData.getAttachmentPath());
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setName(emailData.getAttachmentName());
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName(emailData.getHostName()); // smtpvirt.pelephone.co.il  "stargate"
        email.setSmtpPort(emailData.getSmtpPort());
       /* for (String name : emailData.getMailSendTo()){
            try {
                email.addTo(name, "");
            } catch (EmailException e) {
                e.printStackTrace();
            }
        }*/
        try {
            email.setFrom(emailData.getMailFrom(), "");
        } catch (EmailException e) {
            e.printStackTrace();
        }
        email.setSubject(emailData.getMailSubject());
        try {
            email.setMsg(emailData.getMailMsg());
        } catch (EmailException e) {
            e.printStackTrace();
        }
        try {
            email.attach(attachment);
        } catch (EmailException e) {
            e.printStackTrace();
        }
        try {
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
