package tn.kindergarten.sevices;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.kindergarten.entities.Event;
import tn.kindergarten.entities.Kindergarten;
import tn.kindergarten.entities.User;
import tn.kindergarten.repository.EventRepository;
import tn.kindergarten.repository.KindergartenRepository;
import tn.kindergarten.repository.UserRepository;

@Service
public class EventService implements IEventService {

	
	@Autowired
	EventRepository eventrep;
	@Autowired
	UserRepository userrep;
	@Autowired
	KindergartenRepository kinderrep;
	
	@Override
	public int ajouterEvent(Event event) {
		eventrep.save(event);
		return event.getId();
	}

	@Override
	public List<Event> getAllEvents() {
		return (List<Event>) eventrep.findAll();
	}

	@Override
	public void deleteEventById(int EventId) {
		Event e =eventrep.findById(EventId).orElse(null);
		eventrep.delete(e);
		
	}

	@Override
	public int getNombreEventJPQL() {
		return eventrep.getNombreEventJPQL();
	}

	@Override
	public List<String> getAllEventNamesJPQL() {
		return eventrep.getAllEventNamesJPQL();
	}

	@Override
	public void updateEvent(Event e, int idEvent) {
		Event event = eventrep.findById(idEvent).get();
		event.setDateOfEvent(e.getDateOfEvent());
		event.setDescription(e.getDescription());
	    event.setName(e.getName());
		eventrep.save(event);
			
	}

	@Override
	public Event getEvent(String name) {
		return eventrep.getEvent(name);
	}

	

	@Override
	public void kindergartenaEvent(int kinderId, int EventId) {
		Kindergarten k =kinderrep.findById(kinderId).orElse(null);
		Event e =eventrep.findById( EventId).orElse(null);
		e.setKindergarten(k);
		eventrep.save(e);
		
	}

	@Override
	public void useraEvent(int userId, int EventId) {
		User u =userrep.findById(userId).orElse(null);
		Event e =eventrep.findById( EventId).orElse(null);
		e.setUser(u);
		eventrep.save(e);
		
	}

}
