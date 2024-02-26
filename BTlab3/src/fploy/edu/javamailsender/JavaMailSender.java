package fploy.edu.javamailsender;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class JavaMailSender {
	 public static void main(String[] args) {
		 	//mail và mật khẩu là app password
	        final String username = "vinhnh.2312@gmail.com";
	        final String password = "bnmmahhirqmoliay";

	        Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
	        prop.put("mail.smtp.port", "587");
	        prop.put("mail.smtp.auth", "true");
	        prop.put("mail.smtp.starttls.enable", "true"); //TLS
	        
	        Session session = Session.getInstance(prop,
	                new Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username, password);
	                    }
	                });

	        try {

	            Message message = new MimeMessage(session);
	            //mail cá nhân
	            message.setFrom(new InternetAddress("vinhnh.2312@gmail.com"));
	            //Gửi đến ai
	            message.setRecipients(
	                    Message.RecipientType.TO,
	                    InternetAddress.parse("vinh.nguyenbk7979@hcmut.edu.vn")
	            );
	            //tiêu đề mail
	            message.setSubject("Testing Gmail TLS");
	            //nội dung mail
	            message.setText("Dear Vinh,"
	                    + "\n\n Test mail thử nha!");

	            Transport.send(message);

	            System.out.println("Done");

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    }
}
