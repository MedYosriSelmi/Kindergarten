package tn.kindergarten.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tn.kindergarten.sevices.IRatingEventService;

@Controller

public class RatingEventController {

	@Autowired
	IRatingEventService ratEventServ;
	
	
	
	@PostMapping("/AddRating/{idUser}/{idEvent}/{valueRating}")
	public String addRatingEvent(@PathVariable("idUser") int idUser,@PathVariable("idEvent")int idEvent ,float ratingValue) 
	{
		return ratEventServ.addRatingEvent(idUser, idEvent, ratingValue);
	}
	@GetMapping("/rating/{idEvent}/{idUser}")
	public float getValueRatingByEventAndUser(@PathVariable("idEvent")int idEvent,@PathVariable("idUser") int idUser) {
		return ratEventServ.getValueRatingByEventAndUser(idEvent, idUser);
	}
}
