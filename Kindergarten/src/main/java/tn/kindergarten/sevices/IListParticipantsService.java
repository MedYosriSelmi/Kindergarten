package tn.kindergarten.sevices;

import java.util.List;

import tn.kindergarten.entities.Child;
import tn.kindergarten.entities.Event;

import tn.kindergarten.entities.User;

public interface IListParticipantsService {
	
	public void Participer(int userId, int eventId); //aussi annuler 
	
	public List<User> getAllUserByEvent(int eventId);
	
	public List<Event> getAllEventByUser(int userId);
	
	
	public int getNombreParticipantsJPQL();
	
	public List<Child> getChildForUserInKinderJPQL( int user, int kindergarten);
	
	
}
