package com.mundosica.core.Utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Gmail {
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
	static String login = "username";
	static String password = "secret";
	static String to = null;
	static String cc = null;
	static String bcc = null;
	static String subject = null;
	static String body = null;
	
	public static void config(String... namesAndValues) {
		if (namesAndValues.length % 2 == 1) {
			throw new IllegalArgumentException("The number of arguments must be pair.");
		}
		String nameConfig = null, valueConfig = null;
		for (int i = 0; i < namesAndValues.length - 1; i += 2) {
			nameConfig = namesAndValues[i].trim().toLowerCase();
			valueConfig = namesAndValues[i +1];
			switch	(nameConfig) {
				case "username":
				case "login":
					Gmail.login = valueConfig;
					break;
				case "password":
				case "pass":
					Gmail.password = valueConfig;
					break;
				case "to":
					Gmail.to = valueConfig;
					break;
				case "cc":
					Gmail.cc = valueConfig;
					break;
				case "bcc":
					Gmail.bcc = valueConfig;
					break;
				case "title":
				case "subject":
					Gmail.subject = valueConfig;
					break;
				case "msg":
				case "body":
					Gmail.body = valueConfig;
			}
		}
	}
 public static Boolean send(String... namesAndValues) {
	 Gmail.config(namesAndValues);
	 try {
		return Gmail.send();
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return false;
 }
 	public static Boolean send() throws AddressException, MessagingException {
 	Boolean success = false;
	mailServerProperties = System.getProperties();
	mailServerProperties.put("mail.smtp.port", "587");
	mailServerProperties.put("mail.smtp.auth", "true");
	mailServerProperties.put("mail.smtp.starttls.enable", "true");
	getMailSession = Session.getDefaultInstance(mailServerProperties, null);
	generateMailMessage = new MimeMessage(getMailSession);
	if (Gmail.to != null) {
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(Gmail.to));
	}
	if (Gmail.cc != null) {
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(Gmail.cc));
	}
	if (Gmail.bcc != null) {
		generateMailMessage.addRecipient(Message.RecipientType.BCC, new InternetAddress(Gmail.bcc));
	}
	if (Gmail.subject == null) {
		Gmail.subject = "subject gmail object";
	}
	generateMailMessage.setSubject(Gmail.subject);
	if (Gmail.body == null) {
		Gmail.body = "<h1>body gmail object</h1><p>it's a simple test</p>";
	}
	generateMailMessage.setContent(Gmail.body, "text/html");
	//Step3
	Transport transport = getMailSession.getTransport("smtp");
	// Enter your correct gmail UserID and Password (XXXApp Shah@gmail.com)
	if (Gmail.login == null || Gmail.password == null) {
		return success;
	}
	transport.connect("smtp.gmail.com", Gmail.login, Gmail.password);
	transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
	transport.close();
	return success;
}

}
