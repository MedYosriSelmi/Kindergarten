package tn.kindergarten.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.kindergarten.entities.User;
import tn.kindergarten.services.PublicationService;
import tn.kindergarten.entities.Publication;

@RestController
@RequestMapping("/publication")
public class PublicationController {
	
	
	@Autowired
	PublicationService pubSer;

	/*
	@PostMapping("/addPublication") //DONE
	public int AddPublication(@RequestBody Publication pub){
		pubSer.AddPublication(pub);
	    return pub.getId();
	}*/
	
	
	@PostMapping("/addPublication/{idUser}/{idKind}") //DONE
	public int AddPublication(@RequestBody Publication pub, @PathVariable int idUser, @PathVariable int idKind){
		pubSer.AddPublication(pub, idUser, idKind);
	    return pub.getId();
	}
	
	@GetMapping("/getAllPublications") //DONE
	public List<Publication> listPublications(){
		return pubSer.listPublications();
	}
	
	@DeleteMapping("/deletePublication/{idpub}") //DONE
	public void DeletePublication(@PathVariable int idpub) {
		pubSer.DeletePublication(idpub);
	}
	 
	@PutMapping("/updatePublication/{pubId}/{description}/{photo}") //DONE
    public void UpdatePublication(@PathVariable int pubId,@PathVariable String description,@PathVariable String photo){
		pubSer.UpdatePublication(pubId, description, photo);
    }	
	
	@PostMapping("/addUser") //DONE
	public int AddUser(@RequestBody User user){
		pubSer.addUser(user);
	    return user.getId();
	}

}
