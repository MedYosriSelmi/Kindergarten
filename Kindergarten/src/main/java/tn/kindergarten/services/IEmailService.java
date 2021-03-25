package tn.kindergarten.services;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface IEmailService {
	
	public void sendEmailforUser(int idUser,String subject, String body) throws AddressException, MessagingException;
	public void sendEmailforUserReview(int idUser) throws AddressException, MessagingException;
	
}
