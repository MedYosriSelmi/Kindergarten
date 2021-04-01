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

import tn.kindergarten.entities.Planning;
import tn.kindergarten.entities.User;
import tn.kindergarten.services.PlanningService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/planning")

public class PlanningController {
	
	@Autowired
	PlanningService planSer;

	/*
	@PostMapping("/addPlanning") //DONE
	public int AddPlanning(@RequestBody Planning plan){
		planSer.AddPlanning(plan);
	    return plan.getId();
	}
	*/
	
	@RequestMapping("/addPlanning/{idUser}/{idKind}") //DONE
	public void AddPlanning(@RequestParam("Departure") String Departure,@RequestParam("Destination") String Destination,@RequestParam("Time") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ") Date Time ,@PathVariable int idUser, @PathVariable int idKind){
		planSer.AddPlanning(Departure, Destination, Time, idKind, idUser);
	}
	
	
	@GetMapping("/getAllPlannings") //DONE
	public List<Planning> listPlannings(){
		return planSer.listPlannings();
	}
	
	@DeleteMapping("/deletePlanning/{idplan}") //DONE
	public void DeletePlanning(@PathVariable int idplan) {
		planSer.DeletePlanning(idplan);
	}
	 
	@RequestMapping("/updatePlanning/{planId}") //DONE
    public void UpdatePublication(@PathVariable int planId, @RequestParam("Departure") String Departure, @RequestParam("Destination") String Destination){
		planSer.UpdatePlanning(planId, Departure, Destination);
    }	
	
	@PostMapping("/addUser") //DONE
	public int AddUser(@RequestBody User user){
		planSer.addUser(user);
	    return user.getId();
	}
	

	@GetMapping("/searchPlanningByDate/{date}")  //DONE
    public List<Planning> searchPlanningByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ") Date date){
		return planSer.searchPlanningByDate(date);
    }
	
	
	@GetMapping("/getNbTotalPlannings") //DONE
    public long getNbTotalPlannings(){
    	return planSer.getTotalPlannings();
    }
	
	@GetMapping("/sendSMS/{idUser}") 
	public void sendSMSforUser(@PathVariable int idUser) {
		planSer.sendSMSforUser(idUser);
	}

}
