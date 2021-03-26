package tn.kindergarten.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import tn.kindergarten.entities.RatingModel;
import tn.kindergarten.sevices.IRatingEventService;



@Controller
@RequestMapping({ "/", "/index" })
public class IndexController {

	
	@Autowired
	IRatingEventService ratEvent;
	
    @GetMapping
    public String main(Model model) {
        model.addAttribute("rating", new RatingModel());
        return "index";
    }

    @PostMapping
    public String save(RatingModel rating, Model model) {
       model.addAttribute("rating", rating);
       return "saved";
   }
    
    
	//@PostMapping
	//public String addRatingEvent(RatingModel rating)
	//{
		//return ratEvent.addRatingEvent(1,1,rating.getStars());
		
	//}
}