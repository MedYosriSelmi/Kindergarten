package tn.kindergarten.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.kindergarten.entities.Child;
import tn.kindergarten.services.IChildService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class ChildController {

	@Autowired
	IChildService childserv;
	
	@PostMapping("/ajouterChild")
	@ResponseBody
	//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Child ajouterChild(@RequestBody Child child)
	{
		childserv.ajouterChild(child);
		return child;
	}
	
	@DeleteMapping("/deleteChildById/{idChild}") //done
	@ResponseBody 
	public void deleteEmployeById(@PathVariable("idChild")int childId) {
		childserv.deleteChildById(childId);	
	}
	
	@PutMapping("/updateChild/{idChild}")
  	@ResponseBody
  	public ResponseEntity<String> updateChild(
  		@RequestBody Child child,@PathVariable("idCHild")int idChild) {
		childserv.updateChild(child,idChild);
  	    return new ResponseEntity<String>("Child updated successfully",HttpStatus.OK);
  		
	}
	
	@GetMapping(value="/Children")//done
	@ResponseBody
	public List<Child> getAllChild() {
		return childserv.getAllChild();
	}
	
	@PutMapping(value ="/affecterChildAUser/{iduser}/{idchild}")
	@ResponseBody
	public void affecteChildAUser(@PathVariable("iduser")int userId,@PathVariable("idchild") int childId) {
		childserv.affecterChildAUser(userId, childId);
	} 
	
	@PutMapping(value ="/affecterChildAKindergarten/{iduser}/{idkinder}")
	@ResponseBody
	public void affecteChildAKindergarten(@PathVariable("iduser")int userId,@PathVariable("idkinder") int kinderId) {
		childserv.affecterChildAKindergarten(userId, kinderId);
	} 
	
	@GetMapping("/getAllChildByUser/{iduser}")
    @ResponseBody
	public List<Child> getAllChildByUser(@PathVariable("iduser") int userId) {

		return childserv.getAllChildByUser(userId);
	}
	
	@GetMapping("/getAllChildByKindergrten/{idkinder}")
    @ResponseBody
	public List<Child> getAllChildByKindergarten(@PathVariable("idkinder") int kinderId) {

		return childserv.getAllChildByKindergarten(kinderId);
	}
	
}
