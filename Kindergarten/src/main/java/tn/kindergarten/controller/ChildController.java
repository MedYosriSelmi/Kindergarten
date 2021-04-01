package tn.kindergarten.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.kindergarten.entities.Child;
import tn.kindergarten.entities.Kindergarten;
import tn.kindergarten.entities.User;
import tn.kindergarten.services.IChildService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class ChildController {

	@Autowired
	IChildService childserv;
	
	@PostMapping("/ajouterChild")//done
	@ResponseBody
	//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String ajouterChild(@RequestParam("idUser") long idUser,@RequestParam("idkinder") int idkinder ,@RequestParam("date") String date,@RequestParam("name") String name,@RequestParam("file") MultipartFile file )
	{
		childserv.ajouterChild(idUser, idkinder, date, name, file);
		return "Child added sucessfully !! ";
	}
	
	@DeleteMapping("/deleteChildById/{idChild}") //done
	@ResponseBody 
	public String deleteEmployeById(@PathVariable("idChild")int childId) {
		childserv.deleteChildById(childId);	
		return "Child deleted !!";
	}
	
	@PutMapping("/updateChild/{idChild}")
  	@ResponseBody
  	public ResponseEntity<String> updateChild(
  		@RequestBody Child child,@PathVariable("idChild")int idChild) {
		childserv.updateChild(child,idChild);
  	    return new ResponseEntity<String>("Child updated successfully",HttpStatus.OK);
  		
	}
	
	@GetMapping(value="/Children")//done
	@ResponseBody
	public List<Child> getAllChild() {
		return childserv.getAllChild();
	}
	
	
	
	@GetMapping("/getAllChildByUser/{iduser}")//done
    @ResponseBody
	public List<Child> getAllChildByUser(@PathVariable("iduser") long userId) {

		return childserv.getAllChildByUserr(userId);
	}
	
	@GetMapping("/getAllChildByKindergrten/{idkinder}")//done
    @ResponseBody
	public List<Child> getAllChildByKindergarten(@PathVariable("idkinder") int kinderId) {

		return childserv.getAllChildByKindergarten(kinderId);
	}
	
	@PutMapping("/modifyChild")//done
	public String modifyChild(@RequestParam("childId") int childId,@RequestParam("date") String date,@RequestParam("name") String name,@RequestParam("file") MultipartFile file) {
		Child child = new Child();
		String filename=file.getOriginalFilename();
		try {
			file.transferTo(new File("C:\\Users\\Med Yosri\\git\\Kindergarten\\images\\"+file.getOriginalFilename()));
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    try {
			child.setDateOfBirth(formatter.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    child.setName(name);
	    child.setPhoto(filename);
	    
		childserv.updateChild(child,childId);
		return "Child updated succefully!!";
	}
}
