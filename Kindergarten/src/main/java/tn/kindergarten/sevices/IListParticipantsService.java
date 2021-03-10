package tn.kindergarten.sevices;

import java.util.Date;
import java.util.List;

import tn.kindergarten.entities.Event;
import tn.kindergarten.entities.User;

public interface IListParticipantsService {
	
	public void ajouterLP(int userId, int eventId, Date dateP);
	public List<User> getAllUserByEvent(int eventId);
	public List<Event> getAllEventByUser(int userId);
	
	
}
