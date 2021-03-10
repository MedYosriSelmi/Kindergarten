package tn.kindergarten.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.kindergarten.entities.Activity;
import tn.kindergarten.sevices.IActivityService;


@Controller
public class ActivityController  {

	
	@Autowired
	IActivityService iactivityservice;
	
	
//  http://localhost:8081/SpringMVC/servlet/add-activity
 @PostMapping("/add-activity")
 @ResponseBody
	public int ajouterActivity(@RequestBody Activity Activity) {
	 iactivityservice.ajouterActivity(Activity);
	 return Activity.getId();
	}
//URL : http://localhost:8081/SpringMVC/servlet/getAllActivity
	@GetMapping(value = "/getAllActivity")
  @ResponseBody
	public List<Activity> getAllActivity() {
		return iactivityservice.getAllActivity();
	}

	// URL : http://localhost:8081/SpringMVC/servlet/deleteActivityById/1
    @DeleteMapping("/deleteActivityById/{idactivity}") 
	@ResponseBody 
	public void deleteActivityById(@PathVariable("idactivity")int ActivityId) {
    	iactivityservice.deleteActivityById(ActivityId);
		
	}

//  http://localhost:8081/SpringMVC/servlet/NbreActivity
	@GetMapping("/NbreActivity")
	 @ResponseBody
	public int getNombreActivityJPQL() {
		return iactivityservice.getNombreActivityJPQL();
	}

//  http://localhost:8081/SpringMVC/servlet/Activityname
	@GetMapping("/Activityname")
	 @ResponseBody
	public List<String> getAllActivityNamesJPQL() {
		return iactivityservice.getAllActivityNamesJPQL();
	}

	@PutMapping("/updateActivity/{idActivity}")
	@ResponseBody
	public ResponseEntity<String> updateActivity(@RequestBody Activity a,@PathVariable("idActivity") int idActivity){
		iactivityservice.updateActivity(a,idActivity);
  	    return new ResponseEntity<String>("Activity updated successfully",HttpStatus.OK);
		
	}

//  http://localhost:8081/SpringMVC/servlet/getActivity/{name}
	@GetMapping("/getActivity/{name}")
	 @ResponseBody
	public Activity getActivity(@PathVariable("name")String name) {
		return iactivityservice.getActivity(name);
	}
	
	@PutMapping(value ="/kindergartenaActivity/{idkinder}/{idactivity}")
	@ResponseBody
	public void kindergartenaActivity(@PathVariable("idkinder") int kinderId ,@PathVariable("idactivity") int ActivityId){
		iactivityservice.kindergartenaActivity(kinderId,  ActivityId);
	}
	
	@PutMapping(value ="/useraactivity/{iduser}/{idactivity}")
	@ResponseBody
	public void useraactivity(@PathVariable("iduser")int userId,@PathVariable("idactivity") int ActivityId) {
		iactivityservice.useraactivity(userId,  ActivityId);
		
	}

}
