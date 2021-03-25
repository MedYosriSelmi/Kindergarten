package tn.kindergarten.services;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tn.kindergarten.entities.User;
import tn.kindergarten.repository.UserRepository;

@Service
public class EmailService implements IEmailService {

	@Autowired
	UserRepository usRep;
	
	@Value("${spring.mail.username}")
	private String username;
	
	@Value("${spring.mail.password}")
	private String password;
	
	@Override
	public void sendEmailforUser(int idUser, String subject, String body) throws AddressException, MessagingException {
		User u = usRep.findById(idUser).orElse(null);
		String email = u.getEmail();
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  });
		
		Message msg = new MimeMessage(session);
	    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		msg.setSubject(subject);
		msg.setContent(body,"text/html");
		msg.setSentDate(new Date());
		
		// send the e-mail
        Transport.send(msg);

	}

	@Override
	public void sendEmailforUserReview(int idUser) throws AddressException, MessagingException {
		User u = usRep.findById(idUser).orElse(null);
		String email = u.getEmail();
		
	    Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  });
		
		Message msg = new MimeMessage(session);
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		msg.setSubject("Review");
		String htmlMsg = "<h3>Please Check This Link To Get Your Review Form</h3>"
                +"<h3>https://form.jotform.com/210797636697575</h3>";
		msg.setContent(htmlMsg, "text/html");
		msg.setSentDate(new Date());
		
		// send the e-mail
        Transport.send(msg);
		
	}

}
