package tn.kindergarten.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sun.el.parser.ParseException;

import tn.kindergarten.entities.Appointment;
import tn.kindergarten.service.IAppointmentService;

@RestController
public class AppointmentRestControllerImpl {
	@Autowired
	IAppointmentService   appointmentss;
	
	@GetMapping("/lister_date_disponible_byDoctor/{id_user}/{id_doctor}/{date}")
	public String lister_date_disponible_bygarden(@PathVariable("id_user") int id_user,@PathVariable("id_doctor") int id_doctor,@PathVariable("date") String date) throws ParseException,Exception {
		
		return appointmentss.lister_date_disponible_byDoctor(id_user,id_doctor,date);
	}

	

	@PostMapping("/ajouter_Doctor_rendezVous/{id_user}/{id_doctor}")
	public String ajouter_Doctor_rendezVous(@PathVariable("id_user") int id_user,@PathVariable("id_doctor") int id_doctor,@RequestBody Appointment appointment) throws ParseException {
		
		return appointmentss.ajouter_Doctor_rendezVous(id_user,id_doctor,appointment);
	}
	
	@DeleteMapping("/delete_appointment/{user_id}/{appointment_id}")
	public String delete_appointment(@PathVariable("user_id") int user_id,@PathVariable("appointment_id") int appointment_id) throws ParseException {
		
		return appointmentss.delete_appointment(user_id,appointment_id);
	
	}
	@PutMapping("/update_appointment_By_User/{user_id}/{appointment_id}")
	public String update_appointment_By_User(@PathVariable("user_id") int user_id, @PathVariable  ("appointment_id")int appointment_id,@RequestBody Appointment  appointment) {

		
		return appointmentss.update_appointment_By_User( user_id ,appointment_id, appointment);
	}
	
	@GetMapping(value="/listofAppointment")
	@ResponseBody
	public List<Appointment> getAllAppointment() {
		return appointmentss.getAllAppointment();
	}

	@PutMapping("/update_appointment_By_Doctor/{doctor_id}/{appointment_id}")
	public String update_appointment_By_Doctor(@PathVariable("doctor_id") int doctor_id, @PathVariable int appointment_id,@RequestBody Appointment  appointment) {

		
		return appointmentss.update_appointment_By_Doctor( doctor_id ,appointment_id, appointment);
	}


	@PostMapping("/accepte_appointment/{id_doctor}/{appointment_id}")
	public String accepte_appointment(@PathVariable("id_doctor") int id_doctor,@PathVariable("appointment_id") int appointment_id) throws ParseException {
	
		return appointmentss.accepte_appointment(id_doctor,appointment_id);
}
	@PostMapping("/refut_appointment/{id_doctor}/{appointment_id}")
	public String refut_appointment(@PathVariable("id_doctor") int id_doctor,@PathVariable("appointment_id") int appointment_id) throws ParseException {
		
		return appointmentss.refut_appointment(id_doctor,appointment_id);
	
	}
	@GetMapping("/searchappointment/{user_id}/{search}")
	public List<Appointment> searchappointment(@PathVariable("user_id") int user_id, @PathVariable String search) {

		return appointmentss.searchappointment(user_id, search);
	}
	@GetMapping("/getallappointment_status_1/{id_doctor}")
	public List<Appointment> getallappointment_status_1(@PathVariable("id_doctor") int id_doctor) throws ParseException {
	
		return appointmentss.getallappointment_status_1(id_doctor);
	}
	@GetMapping("/findParentAppointment/{user_id}")
	public  List<Appointment> findParentAppointment(@PathVariable("user_id") int user_id) {

		return appointmentss.findParentAppointment(user_id);
	}

	
	
}
