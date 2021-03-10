package tn.kindergarten.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.kindergarten.entities.Event;
import tn.kindergarten.sevices.IEventService;

@Controller
public class EventController   {

	@Autowired
	IEventService ieventservice;
	
	
//  http://localhost:8081/SpringMVC/servlet/add-event
 @PostMapping("/add-event")
 @ResponseBody
	public int ajouterEvent(@RequestBody Event event) {
	 ieventservice.ajouterEvent(event);
	 return event.getId();
	}


 // URL : http://localhost:8081/SpringMVC/servlet/getAllEvent
	@GetMapping(value = "/getAllEvent")
    @ResponseBody
public List<Event> getAllEvents() {
	return ieventservice.getAllEvents();
}


	// URL : http://localhost:8081/SpringMVC/servlet/deleteEventById/1
    @DeleteMapping("/deleteEventById/{idevent}") 
	@ResponseBody 
	public void deleteEventById(@PathVariable("idevent")int EventId) {
    	ieventservice.deleteEventById(EventId);
		
	}

//  http://localhost:8081/SpringMVC/servlet/NbreEvent
	@GetMapping("/NbreEvent")
	 @ResponseBody
	public int getNombreEventJPQL() {
		return ieventservice.getNombreEventJPQL();
	}

//  http://localhost:8081/SpringMVC/servlet/Eventname
	@GetMapping("/Eventname")
	 @ResponseBody
	public List<String> getAllEventNamesJPQL() {
		return ieventservice.getAllEventNamesJPQL();
	}


	@PutMapping("/updateEvent/{idEvent}")
	@ResponseBody
	public ResponseEntity<String> updateEvent(@RequestBody Event e, @PathVariable("idEvent")int idEvent) {
		ieventservice.updateEvent(e,idEvent);
  	    return new ResponseEntity<String>("Event updated successfully",HttpStatus.OK);
		
	}

//  http://localhost:8081/SpringMVC/servlet/getEvent/{name}
	@GetMapping("/getEvent/{name}")
	 @ResponseBody
	public Event getEvent(@PathVariable("name")String name) {
		return ieventservice.getEvent(name);
		
	}


	@PutMapping(value ="/kindergartenaEvent/{idkinder}/{idevent}")
	@ResponseBody
	public void kindergartenaEvent(@PathVariable("idkinder")int kinderId,@PathVariable("idevent") int EventId) {
		ieventservice.kindergartenaEvent(kinderId,  EventId);
		
	}
	@PutMapping(value ="/useraEvent/{iduser}/{idevent}")
	@ResponseBody
	public void useraEvent(@PathVariable("iduser")int userId,@PathVariable("idevent") int EventId) {
		ieventservice.useraEvent(userId,  EventId);
		
	}

}
