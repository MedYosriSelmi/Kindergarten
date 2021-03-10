package tn.kindergarten.Controller;





import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import tn.kindergarten.entities.Event;
import tn.kindergarten.entities.User;
import tn.kindergarten.sevices.IListParticipantsService;

@Controller
public class ListParticipantsController {
	
	@Autowired
	IListParticipantsService ilistservice;
	
	
	// http://localhost:8081/SpringMVC/servlet/ajouterLP
    //{"missionId":1,"employeId":2,"dateDebut":"2020-03-01","dateFin":"2021-03-01"}
	
	@PostMapping("/ajouterLP/{iduser}/{idevent}/{datep}")
	@ResponseBody
	public void ajouterLP(@PathVariable("iduser") int userId, @PathVariable("idevent") int eventId, @PathVariable("datep") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateP) {
		ilistservice.ajouterLP(userId, eventId, dateP);

	}
	 // URL : http://localhost:8081/SpringMVC/servlet/getAllUserByEvent/12
    @GetMapping("/getAllUserByEvent/{idevent}")
    @ResponseBody
	public List<User> getAllUserByEvent(@PathVariable("idevent") int eventId) {

		return ilistservice.getAllUserByEvent(eventId);
	}
    
    // URL : http://localhost:8081/SpringMVC/servlet/getAllEventByUser/12
    @GetMapping("/getAllEventByUser/{iduser}")
    @ResponseBody
	public List<Event> getAllEventByUser(@PathVariable("iduser") int userId) {

		return ilistservice.getAllEventByUser(userId);
	}

}
