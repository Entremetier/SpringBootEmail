package happe.marco.email.controller;

import happe.marco.email.domain.User;
import happe.marco.email.service.NotificationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private final NotificationService service;

    public RegistrationController(NotificationService service) {
        this.service = service;
    }

    @RequestMapping("/signup-success")
    public String signupSuccess(){

        //Create User
        User user = new User();
        user.setName("Max Musterman");
        user.setEmail("max@musterman.de");

        //send notification
        try {
            service.sendNotification(user);
        } catch (Exception e) {
            System.out.println("Errormessage:" + e.getMessage());
        }
        return "Thank you for your mail!";
    }
}
