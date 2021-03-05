package tn.kindergarten.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.kindergarten.entities.Reclamation;
import tn.kindergarten.services.ReclamationService;

@RestController
public class ReclamationController {
	
	@Autowired
	ReclamationService recSer;

	@PostMapping("/AddReclamation") 
	public int AddReclamation(@RequestBody Reclamation reclamation){
		recSer.AddReclamation(reclamation);
	    return reclamation.getId();
	}
	
	@GetMapping("/getAllReclamations")
	public List<Reclamation> listReclamations(){
		return recSer.listReclamations();
	}
	
	@DeleteMapping("/DeleteReclamation/{idRec}") 
	public void DeleteReclamation(@PathVariable int idRec) {
		recSer.DeleteReclamation(idRec);
	}
	
	@PutMapping("/UpdateReclamation/{reclamationId}/{description}/{photo}")
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

}
