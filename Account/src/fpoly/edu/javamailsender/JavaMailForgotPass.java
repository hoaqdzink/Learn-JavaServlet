package fpoly.edu.javamailsender;

import java.util.Properties;

import fpoly.edu.dao.UserDao;
import fpoly.edu.model.User;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class JavaMailForgotPass {
	public static void JavaMailForgotPass(String mail) {
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
        	UserDao dao = new UserDao();
        	User user = dao.findByEmail(mail);
        	dao.findByEmail(mail);
            Message message = new MimeMessage(session);
            //mail cá nhân
            message.setFrom(new InternetAddress("vinhnh.2312@gmail.com"));
            //Gửi đến ai
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(mail)
            );
            //tiêu đề mail
            message.setSubject("Forgot Password " + user.getFullname()+" ");
            //nội dung mail
            message.setText("Dear " + user.getFullname()+" "
                    + "\n\n Mật khẩu của bạn là: " + user.getPassword()
                    +"\n\n Vui lòng không cung cấp mật khẩu với bất kì ai!" );

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
