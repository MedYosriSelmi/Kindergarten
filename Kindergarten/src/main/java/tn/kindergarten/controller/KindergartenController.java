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

import tn.kindergarten.entities.Kindergarten;
import tn.kindergarten.entities.User;
import tn.kindergarten.services.KindergartenService;

@RestController 
@RequestMapping("/kindergarten")
public class KindergartenController {
	

	@Autowired
	KindergartenService KindergartenSer;

	@PostMapping("/addKindergarten") //DONE
	public int AddKindergarten(@RequestBody Kindergarten kindergarten){
		KindergartenSer.AddKindergarten(kindergarten);
	    return kindergarten.getId();
	}
	
	@GetMapping("/getAllKindergartens") //DONE
	public List<Kindergarten> listKindergartens(){
		return KindergartenSer.listKindergartens();
	}
	
	@DeleteMapping("/deleteKindergarten/{idKindergarten}") //DONE
	public void DeleteKindergarten(@PathVariable int idKindergarten) {
		KindergartenSer.DeleteKindergarten(idKindergarten);
	}
	 
	@PutMapping("/updateKindergarten/{KindergartenId}/{description}/{photo}") //DONE
    public void UpdateKindergarten(@PathVariable int KindergartenId,@PathVariable String description,@PathVariable String photo){
		KindergartenSer.UpdateKindergarten(KindergartenId, description, photo);
    }
	
	@GetMapping("/getKindergartenById/{KindergartenId}") //DONE
    public Kindergarten getKindergartenById(@PathVariable int KindergartenId){
    	return KindergartenSer.getKindergartenById(KindergartenId);
    }
	
	@PostMapping("/addUser") //DONE
	public int AddUser(@RequestBody User user){
		KindergartenSer.addUser(user);
	    return user.getId();
	}
	
	@PutMapping("/AffecterUserKindergarten/{userId}/{kindId}")
	public void affecterUserKindergarten(@PathVariable int userId, @PathVariable int kindId) {
		KindergartenSer.affecterUserKindergarten(userId, kindId);
		
	}
		
	
}
