package tn.kindergarten.services;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface IEmailService {
	public void NotifyUserByEmail(int idUser, int idRec) throws AddressException, MessagingException;
	public void CheckReclamationStatus(int idUser, int idRec) throws AddressException, MessagingException;
}
