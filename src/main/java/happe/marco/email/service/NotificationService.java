package happe.marco.email.service;

import happe.marco.email.domain.User;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final JavaMailSender sender;

    public NotificationService(JavaMailSender sender) {
        this.sender = sender;
    }

    public void sendNotification(User user) throws MailException{

            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(user.getEmail());
            mail.setFrom("hans@wurst.com");
            mail.setSubject("Eine Mail");
            mail.setText("Eureka, es hat geklappt");
            sender.send(mail);

            System.out.println("Mail sent!");
    }
}
