package tn.kindergarten.sevices;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tn.kindergarten.entities.Event;

public interface IEventService {
	
	public ResponseEntity<String> ajout(Event event, int kinderId,int userId,MultipartFile file);
	
	public List<Event> getAllEvents();
	
	public void deleteEventById(int EventId);
	
	public int getNombreEventJPQL();
	
	public List<String> getAllEventNamesJPQL();
	
	public void updateEvent(Event e, int idEvent, MultipartFile file);
	
	public Event getEvent(String name);
	
	public List<Event> getAllEventPourToday();
	 
	public List<Event> getAllEventOrdonneParDate();
	 
    public void assiAttachementToPost(int id , MultipartFile file);
	 
	
	 
	
	
}
