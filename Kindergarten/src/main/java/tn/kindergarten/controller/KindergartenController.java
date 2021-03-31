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

import tn.kindergarten.entities.Kindergarten;
import tn.kindergarten.entities.User;
import tn.kindergarten.services.KindergartenService;

@RestController 
@RequestMapping("/kindergarten")
public class KindergartenController {
	

	@Autowired
	KindergartenService KindergartenSer;

	@RequestMapping("/addKindergarten/") //DONE
	public void AddKindergarten(@RequestParam("description") String description, @RequestParam("email") String email, @RequestParam("location") String location, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("photo") MultipartFile photo, @RequestParam("pricePerChild") Float pricePerChild) throws IllegalStateException, IOException{
		KindergartenSer.AddKindergarten(description, email, location, name, phone, photo, pricePerChild);
	}
	
	@GetMapping("/getAllKindergartens") //DONE
	public List<Kindergarten> listKindergartens(){
		return KindergartenSer.listKindergartens();
	}
	
	@DeleteMapping("/deleteKindergarten/{idKindergarten}") //DONE
	public void DeleteKindergarten(@PathVariable int idKindergarten) {
		KindergartenSer.DeleteKindergarten(idKindergarten);
	}
	 
	@RequestMapping("/updateKindergarten/{id}") //DONE
    public void UpdateKindergarten(@PathVariable int id, @RequestParam("description") String description, @RequestParam("photo") MultipartFile photo) throws IllegalStateException, IOException{
		KindergartenSer.UpdateKindergarten(id,description, photo);
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
	
	@GetMapping("/findByPrice/{price}") //DONE
	public List<Kindergarten> SearchByPrice(@PathVariable float price){
		return KindergartenSer.SearchByPrice(price);
	}
	
	@GetMapping("/sortByPrice") //DONE
	public List<Kindergarten> findByPrice(){
		return KindergartenSer.findByPrice();
	}
	
}
