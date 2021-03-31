package tn.kindergarten.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	
	/*
	@RequestMapping("/addPublication/") //DONE
	public void AddPublication(@RequestParam("description") String description, @RequestParam("photo") MultipartFile photo, @RequestParam("idUser") int idUser, @RequestParam("idKind") int idKind) throws IllegalStateException, IOException{
		pubSer.AddPublication(description, photo, idUser, idKind);
	}*/
	
	@RequestMapping("/addPublication/{idUser}/{idKind}") //DONE
	public void AddPublication(@PathVariable int idUser, @PathVariable int idKind, @RequestParam("description") String description, @RequestParam("photo") MultipartFile photo) throws IllegalStateException, IOException{
		pubSer.AddPublication(idUser, idKind, description, photo);
	}
	@GetMapping("/getAllPublications") //DONE
	public List<Publication> listPublications(){
		return pubSer.listPublications();
	}
	
	@DeleteMapping("/deletePublication/{idpub}") //DONE
	public void DeletePublication(@PathVariable int idpub) {
		pubSer.DeletePublication(idpub);
	}
	 
	@RequestMapping("/updatePublication/") //DONE
    public void UpdatePublication(@RequestParam("id") int pubId, @RequestParam("description") String description, @RequestParam("photo") MultipartFile photo) throws IllegalStateException, IOException {
		pubSer.UpdatePublication(pubId, description, photo);
    }	
	
	@PostMapping("/addUser") //DONE
	public int AddUser(@RequestBody User user){
		pubSer.addUser(user);
	    return user.getId();
	}

}
