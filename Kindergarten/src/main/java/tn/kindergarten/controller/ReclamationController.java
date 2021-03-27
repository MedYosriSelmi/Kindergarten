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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tn.kindergarten.entities.Reclamation;
import tn.kindergarten.entities.Status;
import tn.kindergarten.services.EmailService;
import tn.kindergarten.services.ReclamationService;

@RestController
public class ReclamationController {
	
	@Autowired
	ReclamationService recSer;
	
	@Autowired
	EmailService emailSer;

	@RequestMapping("/addReclamation/{idUser}/{idKinder}") //Pending
	public void AddReclamation(@PathVariable int idUser, @PathVariable int idKinder, @RequestParam("description") String description,@RequestParam("date") String date,@RequestParam("type") String type,@RequestParam("status") Status status, @RequestParam("photo") MultipartFile file) throws IllegalStateException, IOException{
		recSer.AddReclamation(idUser, idKinder, description, date, type, status, file);
	}
	
	@GetMapping("/getAllReclamations") //DONE
	public List<Reclamation> listReclamations(){
		return recSer.listReclamations();
	}
	
	@DeleteMapping("/deleteReclamation/{idUser}/{idRec}") //DONE
	public void DeleteReclamation(@PathVariable int idUser, @PathVariable int idRec) {
		recSer.DeleteReclamation(idUser, idRec);
	}
	 
	@PutMapping("/updateReclamation/{idUser}/{reclamationId}") //DONE
    public void UpdateReclamation(@PathVariable int idUser, @PathVariable int reclamationId,@RequestParam("description") String description,@RequestParam("photo") MultipartFile photo) throws IllegalStateException, IOException{
    	recSer.UpdateReclamation(idUser, reclamationId, description, photo);
    }
	
	@GetMapping("/getReclamationById/{reclamationId}") //DONE
    public Reclamation getReclamationById(@PathVariable int reclamationId){
    	return recSer.getreclamationById(reclamationId);
    }
	
	@GetMapping("/getNbTotalReclamation") //DONE
    public long getNombreReclamation(){
    	return recSer.getTotalReclamation();
    }
	
	@GetMapping("/getNbNewReclamation") //DONE
    public long getNbNewReclamation(){
    	return recSer.getNbNewReclamation();
    }
	
	@GetMapping("/getNbPendingReclamation") //DONE
    public long getNbPendingReclamation(){
    	return recSer.getNbPendingReclamation();
    }
	
	@GetMapping("/FiltrerReclamationsByDateAndType/{type}/{d1}/{d2}")  //DONE
    public List<Reclamation> FiltrerReclamationsByDateAndType(@PathVariable String type, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date d1, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date d2){
    	return recSer.FiltrerReclamationsByDateAndType(type, d1, d2); 
    }
	
	@GetMapping("/FiltrerReclamationsByDateAndStatus/{status}/{d1}/{d2}")  //DONE
    public List<Reclamation> FiltrerReclamationsByDateAndStatus(@PathVariable Status status, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date d1, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date d2){
    	return recSer.FiltrerReclamationsByDateAndStatus(status, d1, d2); 
    }
	
	@GetMapping("/getAllReclamationsByUserId/{idUser}") //DONE
	public List<Reclamation> getallReclamationsbyUserId(@PathVariable("idUser") int idUser) {
		return recSer.getallReclamationsByUserId(idUser);
	}
	
	@GetMapping("/getAllReclamationsByKindergartenId/{idKindergarten}") //DONE
	public List<Reclamation> getallReclamationsbyKindergarten(@PathVariable("idKindergarten") int kindergartenId) {
		return recSer.getallReclamationsByKindergartenId(kindergartenId);
	}
	
	@GetMapping("/getallReclamationsByTypeAndStatus/{type}/{status}") //DONE
	public List<Reclamation> getallReclamationsByTypeAndStatus(@PathVariable String type, @PathVariable Status status) {
		return recSer.getallReclamationsByTypeAndStatus(type, status);
	}
	
	@GetMapping("/getallReclamationsCombined/{keyword}") //DONE
	public List<Reclamation> CombinedSearchReclamation(@PathVariable String keyword) {
		return recSer.CombinedSearchReclamation(keyword);
	}
	
	@GetMapping("/searchReclamationByDate/{date}")  //DONE
    public List<Reclamation> searchReclamationByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
		return recSer.searchReclamationByDate(date);
    }
	
	@GetMapping("/getallReclamationsByStatusSorted/{status}") //DONE
	public List<Reclamation> getallReclamationsByStatusSorted(@PathVariable Status status) {
		return recSer.getListReclamationsByStatusSorted(status);
	}
	
	@GetMapping("/sendSMS/{idUser}/{body}") //DONE
	public void sendSMSforUser(@PathVariable int idUser,@PathVariable String body) {
		recSer.sendSMSforUser(idUser, body);
	}
	
	@PostMapping("/sendEmail/{idUser}/{subject}/{body}") //DONE
	public String sendEmailforUser(@PathVariable int idUser,@PathVariable String subject,@PathVariable String body) throws AddressException, MessagingException{
		emailSer.sendEmailforUser(idUser, subject, body);
		return "Email sent successfully";
	}
	
	@PostMapping("/sendEmail/{idUser}") //DONE
	public String sendEmailforUserReview(@PathVariable int idUser) throws AddressException, MessagingException{
		emailSer.sendEmailforUserReview(idUser);
		return "Email sent";
	}
	
}
