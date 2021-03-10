package tn.kindergarten.sevices;

import java.util.List;


import tn.kindergarten.entities.Event;

public interface IEventService {
	public int ajouterEvent(Event event);
	public List<Event> getAllEvents();
	public void deleteEventById(int EventId);
	public int getNombreEventJPQL();
	public List<String> getAllEventNamesJPQL();
	public void updateEvent(Event e, int idEvent);
	public Event getEvent(String name);
	public void kindergartenaEvent( int kinderId , int EventId);
	public void useraEvent( int userId , int EventId);
	
	
}
