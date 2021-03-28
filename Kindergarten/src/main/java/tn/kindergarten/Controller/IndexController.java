package tn.kindergarten.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tn.kindergarten.entities.Rating;

import tn.kindergarten.sevices.IRatingEventService;



@Controller
@RequestMapping({ "/", "{idEvent}" })
public class IndexController {

	
	@Autowired
	IRatingEventService ratEvent;
	
    @GetMapping
    public String main(Model model) {
        model.addAttribute("rating", new Rating());
        return "index";
    }

   // @PostMapping
   // public String save(RatingModel rating, Model model) {
    //   model.addAttribute("rating", rating);
    //   return "saved";
  // }
    
    
	@PostMapping("{idEvent}")
	public String addRatingEvent(Rating rating ,@PathVariable("idEvent") int idEvent)
	{
	 ratEvent.addRatingEvent(1,idEvent,rating.getRatingValue());
		return "saved";
		}
}