package com.email.api.sendemail.Controller;

import com.email.api.sendemail.Model.EmailRequest;
import com.email.api.sendemail.Service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/welcome")
    public String welcome()
    {
        return"This is just for testing";
    }
    // Api to sent Email
    
    @PostMapping("/sendEmail")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){

      this.emailService.sendEmail(request.getMessage(),request.getSubject(),request.getTo());

     return ResponseEntity.ok("done");

    }
}