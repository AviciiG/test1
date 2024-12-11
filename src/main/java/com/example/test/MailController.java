package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mail")
public class MailController {

    private final MailService mailService;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/send")
    public String showSendEmailPage(Model model) {
        model.addAttribute("email", "");
        model.addAttribute("username", "");
        return "send-email";
    }

    @PostMapping("/send")
    public String sendEmail(@RequestParam String email, @RequestParam String username, Model model) {
        mailService.sendEmail(email, "Welcome to TodoList App", "Hello, " + username + "! Welcome to our application.");
        model.addAttribute("message", "Email successfully sent to " + email);
        return "send-email";
    }
}
