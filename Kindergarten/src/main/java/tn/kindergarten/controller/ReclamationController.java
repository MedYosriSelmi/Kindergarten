package tn.kindergarten.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import tn.kindergarten.entities.Reclamation;
import tn.kindergarten.entities.Status;
import tn.kindergarten.entities.User;
import tn.kindergarten.services.EmailService;
import tn.kindergarten.services.ReclamationService;

@RestController
public class ReclamationController {
	
	@Autowired
	ReclamationService recSer;
	
	@Autowired
	EmailService emailSer;

	@RequestMapping("/addReclamation/{idUser}") //OK
	public String AddReclamation(@PathVariable int idUser, @RequestParam("description") String description,@RequestParam("date") String date,@RequestParam("type") String type,@RequestParam("status") Status status, @RequestParam("photo") MultipartFile file) throws IllegalStateException, IOException{
		recSer.AddReclamation(idUser, description, date, type, status, file);
	    return "Data Saved Successfully";
	}
	
	@GetMapping("/getAllReclamations") //OK
	public List<Reclamation> listReclamations(){
		return recSer.listReclamations();
	}
	
	@DeleteMapping("/deleteReclamation/{idRec}") //OK
	public String DeleteReclamation(@PathVariable int idRec) {
		recSer.DeleteReclamation(idRec);
		return "Reclamation Deleted";
	}
	 
	@PutMapping("/updateReclamation/{reclamationId}") //OK
    public void UpdateReclamation(@PathVariable int reclamationId,@RequestParam("description") String description,@RequestParam("photo") MultipartFile photo) throws IllegalStateException, IOException{
    	recSer.UpdateReclamation(reclamationId, description, photo);
    }
	
	@GetMapping("/getReclamationById/{reclamationId}") //OK
    public Reclamation getReclamationById(@PathVariable int reclamationId){
    	return recSer.getreclamationById(reclamationId);
    }
	
	@GetMapping("/getNombreReclamation") //OK
    public long getNombreReclamation(){
    	return recSer.getTotalReclamation();
    }
	
	@GetMapping("/FiltrerReclamationsByDateAndType/{type}/{d1}/{d2}")  //OK
    public List<Reclamation> FiltrerReclamationsByDateAndType(@PathVariable String type, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date d1, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date d2){
    	return recSer.FiltrerReclamationsByDateAndType(type, d1, d2); 
    }
	
	@GetMapping("/FiltrerReclamationsByDateAndStatus/{status}/{d1}/{d2}")  //OK
    public List<Reclamation> FiltrerReclamationsByDateAndStatus(@PathVariable Status status, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date d1, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date d2){
    	return recSer.FiltrerReclamationsByDateAndStatus(status, d1, d2); 
    }
	
	@PostMapping("/addUser") //OK
	public int AddUser(@RequestBody User user){
		recSer.addUser(user);
	    return user.getId();
	}
	
	@PostMapping("/addKindergarten") //OK
	public int AddUser(@RequestBody Kindergarten kindergarten){
		recSer.addKindergarten(kindergarten);
	    return kindergarten.getId();
	}
	
	@GetMapping("/getAllReclamationsByUserId/{idUser}") //OK
	public List<Reclamation> getallReclamationsbyUserId(@PathVariable("idUser") int idUser) {
		return recSer.getallReclamationsByUserId(idUser);
	}
	
	@GetMapping("/getAllReclamationsByKindergartenId/{idKindergarten}") //Pending
	public List<Reclamation> getallReclamationsbyKindergarten(@PathVariable("idKindergarten") int kindergartenId) {
		return recSer.getallReclamationsByKindergartenId(kindergartenId);
	}
	
	@GetMapping("/getallReclamationsByTypeAndStatus/{type}/{status}") //OK
	public List<Reclamation> getallReclamationsByTypeAndStatus(@PathVariable String type, @PathVariable Status status) {
		return recSer.getallReclamationsByTypeAndStatus(type, status);
	}
	
	@GetMapping("/getallReclamationsCombined/{keyword}") //OK
	public List<Reclamation> CombinedSearchReclamation(@PathVariable String keyword) {
		return recSer.CombinedSearchReclamation(keyword);
	}
	
	@GetMapping("/getallReclamationsByStatusSorted/{status}") //OK
	public List<Reclamation> getallReclamationsByStatusSorted(@PathVariable Status status) {
		return recSer.getListReclamationsByStatusSorted(status);
	}
	
	@GetMapping("/sendSMS/{idUser}/{body}") //OK
	public String sendSMSforUser(@PathVariable int idUser,@PathVariable String body) {
		recSer.sendSMSforUser(idUser, body);
		return "Message sent succesfully";
	}
	
	@PostMapping("/sendEmail/{idUser}/{subject}/{body}") //OK
	public String sendEmailforUser(@PathVariable int idUser,@PathVariable String subject,@PathVariable String body) throws AddressException, MessagingException{
		emailSer.sendEmailforUser(idUser, subject, body);
		return "Email sent successfully";
	}
	
	@PostMapping("/sendEmail/{idUser}") //OK
	public String sendEmailforUserReview(@PathVariable int idUser) throws AddressException, MessagingException{
		emailSer.sendEmailforUserReview(idUser);
		return "Email sent";
	}
	
	@DeleteMapping("/deleteUser/{idUser}") //OK
	public void DeleteUser(@PathVariable int idUser) {
		recSer.DeleteUser(idUser);
	}
	
}
