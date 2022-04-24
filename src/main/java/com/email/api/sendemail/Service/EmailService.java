package com.email.api.sendemail.Service;

import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.websocket.Session;

import org.apache.catalina.Authenticator;
import org.apache.logging.log4j.message.Message;
import org.springframework.boot.rsocket.server.RSocketServer.Transport;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

// This methos will send  Email
    public boolean sendEmail(String subject, String message ,String to){

        boolean f= false;

        String from= "Shashikantydava0@gmail.com";

        //Variable for gmail
		String host="smtp.gmail.com";
		
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES "+properties);
		
		//setting important information to properties object
		
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//Step 1: to get the session object..
		Session session=Session.getPasswordAuthenticationstance(properties, new javax.mail.Authenticator() {
			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {				
				return new javax.mail.PasswordAuthentication("Shashikantyadav0@gmail.com", "8130306151");
			}
			
			
			
		});
		
		session.setDebug(true);
		
		//Step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);
		
		try {
		
		//from email
		m.setFrom(from);
		
		//adding recipient to message
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//adding subject to message
		m.setSubject(subject);
	
		
		//adding text to message
		m.setText(message);
		
		//send 
		
		//Step 3 : send the message using Transport class
		Transport.send(m);
		
		System.out.println("Sent success...................");
		f=true;
		
		}catch (Exception e) {
			e.printStackTrace();
		}

        return true;
			
	}
}




    }
    
}
