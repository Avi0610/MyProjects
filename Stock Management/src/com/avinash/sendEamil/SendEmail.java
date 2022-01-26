package com.avinash.sendEamil;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class SendEmail {
	
	public void sendMessage(Properties props, String username, String password, String str) {
		 try {
		     Session session = Session.getDefaultInstance(props, 
		                          new Authenticator(){
		                             protected PasswordAuthentication getPasswordAuthentication() {
		                                return new PasswordAuthentication(username, password);
		                             }});

		   // -- Create a new message --
		     Message msg = new MimeMessage(session);

		  // -- Set the FROM and TO fields --
		     msg.setFrom(new InternetAddress("doremondisney9@gmail.com"));
		     msg.setRecipients(Message.RecipientType.TO, 
		                      InternetAddress.parse("doremondisney9@gmail.com",false));
		     msg.setSubject("Hello");
		     msg.setText(str);
		     msg.setSentDate(new Date());
		     Transport.send(msg);
		     System.out.println("Message sent. Successfull");
		     	} 
		     catch (MessagingException e) { 
		    	 System.out.println("Erreur d'envoi, cause: " + e);
		     	}
	}
	
	public void pro() {
		 final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		  // Get a Properties object
		     Properties props = System.getProperties();
		     props.setProperty("mail.smtp.host", "smtp.gmail.com");
		     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		     props.setProperty("mail.smtp.socketFactory.fallback", "false");
		     props.setProperty("mail.smtp.port", "465");
		     props.setProperty("mail.smtp.socketFactory.port", "465");
		     props.put("mail.smtp.auth", "true");
		     props.put("mail.debug", "true");
		     props.put("mail.store.protocol", "pop3");
		     props.put("mail.transport.protocol", "smtp");
		     final String username = "doremondisney9@gmail.com";//
		     final String password = "";
	}
  public static void main(String[] args) {
 
     
//     SendEmail email = new SendEmail();
//     email.pro();
//     email.sendMessage(System.getProperties(), "doremondisney9@gmail.com","","avinash singh");
    
  	}
}
