package tn.kindergarten.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.kindergarten.entities.Appointment;
import tn.kindergarten.service.IAppointmentService;

@RestController
public class AppointmentRestControllerImpl {
	@Autowired
	IAppointmentService   appointmentss;
	@PostMapping("/addappointment")
	@ResponseBody
	public int ajouterAppointment(@RequestBody Appointment appointment) {
		appointmentss.ajouterAppointment(appointment) ;
		return appointment.getId();
	}
	@DeleteMapping("/deleteAppointmentBillById/{ent-id}")
	public void deleteAppointmentById(@PathVariable("ent-id") int ide) {
		appointmentss.deleteAppointmentById(ide);		
	}
	@GetMapping(value="/listofAppointment")
	@ResponseBody
	public List<Appointment> getAllAppointment() {
		return appointmentss.getAllAppointment();
	}
	@PutMapping(value ="/affecterRDVaMedecin/{idapp}/{iduser}")
	@ResponseBody
	public void affecterRDVaMedecin(@PathVariable("idapp")int appId,@PathVariable("iduser") int medId) {
		appointmentss.affecterRDVaMedecin(appId, medId);
	}
	
	
	@PutMapping("/updateAppointment/{idAppointment}")
	  	@ResponseBody
	  	public ResponseEntity<String> updateAppointment(
	  		@RequestBody Appointment appointment,@PathVariable("idAppointment")int idAppointment) {
			appointmentss.updateAppointment(appointment,idAppointment);
	  	    return new ResponseEntity<String>("Appointment updated successfully",HttpStatus.OK);
	  		
		}

	
}
