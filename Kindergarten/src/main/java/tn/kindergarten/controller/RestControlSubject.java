package tn.kindergarten.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.kindergarten.entities.Subject;
import tn.kindergarten.service.ISubjectService;

@RestController
public class RestControlSubject {

	@Autowired
	ISubjectService subjectService;


	// http://localhost:8081/SpringMVC/servlet/addSubjectWithImage
	

	@PostMapping("/addSubjectWithImage")
	@ResponseBody
	public void addSubjectWithImage(@RequestParam("description") String description, @RequestParam("name") String name, @RequestParam("file") MultipartFile file, @RequestParam ("isApproved") boolean isApproved, @RequestParam("userId") int userId){

		Subject subject = new Subject();
		String filename=subject.getId() + file.getOriginalFilename();
		try {
			file.transferTo(new File("C:\\Users\\Yassine\\git\\Kindergarten\\Kindergarten\\Images\\"+file.getOriginalFilename()));
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		subject.setPhoto(filename);
		subject.setDescription(description);
		subject.setName(name);
		subject.setApproved(isApproved);
		subjectService.addSubject(subject, userId);

	}

	// http://localhost:8081/SpringMVC/servlet/getAllSubjects

	@GetMapping(value = "getAllSubjects")
	@ResponseBody
	public List<Subject> getAllSubjects(){

		return subjectService.getAllSubjects();

	}


	//http://localhost:8081/SpringMVC/servlet/deleteSubjectById/3
	@DeleteMapping("/deleteSubjectById/{idSub}") 
	@ResponseBody 
	public void deletSubjectById(@PathVariable("idSub") int subjectId){

		subjectService.deleteSubjectById(subjectId);

	}
	
	// http://localhost:8081/SpringMVC/servlet/updateSubject/1
	
	@PutMapping("/updateSubject/{subjectId}")
  	@ResponseBody
  	public ResponseEntity<String> updateSubject(@RequestBody Subject subject,@PathVariable("subjectId")int subjectId) {
		
		subjectService.updateSubject(subject,subjectId);
  	    return new ResponseEntity<String>("Subject updated successfully",HttpStatus.OK);
  		
	}
	
	// http://localhost:8081/SpringMVC/servlet/getTop5
	
	@GetMapping("/getTop5")
	@ResponseBody
	public Set<Subject> findtop5ByOrderByCreationDateDesc(){

		return subjectService.findtop5ByOrderByCreationDateDesc();

	}
	
	@PutMapping("/approveSubject/{subjectId}")
	@ResponseBody
	public void approveSubject(@PathVariable("subjectId") int subjectId){
		
		subjectService.approveSubject(subjectId);
		
	}
	
	
	@GetMapping("/getSubjectsByUserId/{userId}")
	@ResponseBody
	public List<Subject> getSubjectsByUserId(@PathVariable("userId") int userId){
		
		return subjectService.getSubjectByUserId(userId);
		
	}
	


}
