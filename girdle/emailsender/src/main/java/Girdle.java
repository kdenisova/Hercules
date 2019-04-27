public class Girdle {
    public static void main (String[] args) {
        EmailSender myMail = new EmailSender();
        UserInput userInput = new UserInput();
        String recipient = userInput.getUserInput("To: ");
        String subject = userInput.getUserInput("Subject: ");
        String body = userInput.getUserInput("Text: ");
        String password = userInput.getUserInput("Password: ");
        myMail.SendEmail(recipient, subject, body, password);
    }
}
