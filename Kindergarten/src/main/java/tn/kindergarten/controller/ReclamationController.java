package tn.kindergarten.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.kindergarten.entities.Kindergarten;
import tn.kindergarten.entities.Reclamation;
import tn.kindergarten.entities.Status;
import tn.kindergarten.entities.User;
import tn.kindergarten.services.ReclamationService;

@RestController
public class ReclamationController {
	
	@Autowired
	ReclamationService recSer;
	@Autowired
	ReclamationService userSer;

	@PostMapping("/addReclamation") 
	public int AddReclamation(@RequestBody Reclamation reclamation){
		recSer.AddReclamation(reclamation);
	    return reclamation.getId();
	}
	
	@GetMapping("/getAllReclamations") 
	public List<Reclamation> listReclamations(){
		return recSer.listReclamations();
	}
	
	@DeleteMapping("/deleteReclamation/{idRec}") 
	public void DeleteReclamation(@PathVariable int idRec) {
		recSer.DeleteReclamation(idRec);
	}
	 
	@PutMapping("/updateReclamation/{reclamationId}/{description}/{photo}") 
    public void UpdateReclamation(@PathVariable int reclamationId,@PathVariable String description,@PathVariable String photo){
    	recSer.UpdateReclamation(reclamationId, description, photo);
    }
	
	@GetMapping("/getReclamationById/{reclamationId}") 
    public Reclamation getReclamationById(@PathVariable int reclamationId){
    	return recSer.getreclamationById(reclamationId);
    }
	
	@GetMapping("/getNombreReclamation") 
    public long getNombreReclamation(){
    	return recSer.getNombreReclamation();
    }
	
	@GetMapping("/FiltrerReclamationsByDateAndType/{type}/{d1}/{d2}")  
    public List<Reclamation> FiltrerReclamationsByDateAndType(@PathVariable String type, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date d1, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date d2){
    	return recSer.FiltrerReclamationsByDateAndType(type, d1, d2); 
    }
	
	@GetMapping("/FiltrerReclamationsByDateAndStatus/{status}/{d1}/{d2}")  
    public List<Reclamation> FiltrerReclamationsByDateAndStatus(@PathVariable Status status, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date d1, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date d2){
    	return recSer.FiltrerReclamationsByDateAndStatus(status, d1, d2); 
    }
	
	@PostMapping("/addUser") 
	public int AddUser(@RequestBody User user){
		recSer.addUser(user);
	    return user.getId();
	}
	
	@PostMapping("/addKindergarten") 
	public int AddUser(@RequestBody Kindergarten kindergarten){
		recSer.addKindergarten(kindergarten);
	    return kindergarten.getId();
	}
	
	@PutMapping("/InsertReclamationUser/{reclamationId}/{UserId}") 
	public void InsertReclamationUser(@PathVariable int reclamationId,@PathVariable int UserId) {
		recSer.InsertReclamationUser(reclamationId, UserId);
	}
	
	@PutMapping("/InsertReclamationKindergarten/{reclamationId}/{kindergartenId}") 
	public void InsertReclamationKindergarten(@PathVariable int reclamationId,@PathVariable int kindergartenId) {
		recSer.InsertReclamationKindergarten(reclamationId, kindergartenId);
	}
	
	@GetMapping("/getAllReclamationsByUserId/{idUser}") 
	public List<Reclamation> getallReclamationsbyUserId(@PathVariable("idUser") int idUser) {
		return recSer.getallReclamationsByUserId(idUser);
	}
	
	@GetMapping("/getAllReclamationsByKindergartenId/{idKindergarten}") 
	public List<Reclamation> getallReclamationsbyKindergarten(@PathVariable("idKindergarten") int kindergartenId) {
		return recSer.getallReclamationsByKindergartenId(kindergartenId);
	}
	
	@GetMapping("/getallReclamationsByTypeAndStatus/{type}/{status}")
	public List<Reclamation> getallReclamationsByTypeAndStatus(@PathVariable String type, @PathVariable Status status) {
		return recSer.getallReclamationsByTypeAndStatus(type, status);
	}
	
	@GetMapping("/getallReclamationsByStatusSorted/{status}")
	public List<Reclamation> getallReclamationsByStatusSorted(@PathVariable Status status) {
		return recSer.getListReclamationsByStatusSorted(status);
	}

}
