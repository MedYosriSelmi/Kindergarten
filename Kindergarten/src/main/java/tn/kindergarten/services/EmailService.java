package tn.kindergarten.services;

import java.util.Date;
import java.util.List;
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
import tn.kindergarten.entities.Reclamation;
import tn.kindergarten.entities.Role;
import tn.kindergarten.entities.Status;
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
	public void NotifyUserByEmail(int idUser, int idRec) throws AddressException, MessagingException {
		
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
		
		User u = usRep.findById(idUser).orElse(null);
		List<Reclamation> liste = u.getList_reclams();
		for(Reclamation rec : liste){
			if(rec.getId()==idRec && !u.getRole().equals(Role.Admin) && rec.getStatus().equals(Status.Treated)){
				String email = u.getEmail();
				Message msg = new MimeMessage(session);
			    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
				msg.setSubject("Administrative Reminder");
				String htmlMsg = "<h3>Please Check This Link To Get Your Review Form :</h3>"
		                +"<h3>https://form.jotform.com/210797636697575</h3>";
				msg.setContent("<h3>The Client Problem :</h3>" + rec.getDescription() + "<h3>The Date Of Sent :</h3>"+rec.getDateOfReclam()+
						"<h3>After Treatment :</h3>"+"We Solve Your Problem"+htmlMsg,"text/html");
				msg.setSentDate(new Date());
			    // send the e-mail
			    Transport.send(msg);	
			}else	
			    System.out.println("You Can't Send This Email...Please Verify Your Reicever");
		}
		
	}

	@Override
	public void CheckReclamationStatus(int idUser, int idRec) throws AddressException, MessagingException {
		
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
		
		User u = usRep.findById(idUser).orElse(null);
		List<Reclamation> liste = u.getList_reclams();
		for(Reclamation rec : liste){
			if(rec.getId()==idRec){
				String email = u.getEmail();
				Message msg = new MimeMessage(session);
			    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
				msg.setSubject("Reclamation Checking");
				String check = "<h3>Your Reclamation Status In This Moment :</h3>"+rec.getStatus();
				msg.setContent(check,"text/html");
				msg.setSentDate(new Date());
			    // send the e-mail
			    Transport.send(msg);	
			}else	
			    System.out.println("Sorry, This Reclamation Does Not Belong To You...");
		}
	}

}
