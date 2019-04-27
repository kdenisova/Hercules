import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.mailer.config.TransportStrategy;

public class EmailSender {
    public void SendEmail(String To, String Subject, String Body, String password) {
        boolean sent = true;

        Email email = EmailBuilder.startingBlank()
                .to(To)
                .from("java@fancycoder.net")
                .withSubject(Subject)
                .withPlainText(Body)
                .buildEmail();

        Mailer mailer = MailerBuilder
                .withSMTPServer("smtp.yandex.com", 465, "java@fancycoder.net", password)
                .withTransportStrategy(TransportStrategy.SMTPS)
                .buildMailer();
    try {
        mailer.sendMail(email);
    } catch (Exception e) {
        System.out.println("Exception: " + e);
        sent = false;

    }
    if (sent == true) {
        System.out.println("The email has been sent");
    }
    }
}
