package tn.kindergarten.controller;

import java.util.Date;
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

import tn.kindergarten.entities.Subject;
import tn.kindergarten.service.ISubjectService;

@RestController
public class RestControlSubject {

	@Autowired
	ISubjectService subjectService;


	// http://localhost:8081/SpringMVC/servlet/addSubject
	// {"date_subject":"2021-03-04", "description":"first try", "name":"kindergartens", "photo":"link photo"}

	@PostMapping("/addSubject")
	@ResponseBody
	public void addSubject(@RequestBody Subject subject){

		subjectService.addSubject(subject);

	}

	// http://localhost:8081/SpringMVC/servlet/getSubjectById/1

	@GetMapping(value = "getSubjectById/{idSub}")
	@ResponseBody
	public Subject getSubject(@PathVariable ("idSub") int subjectId){

		return subjectService.getSubject(subjectId);

	}

	// http://localhost:8081/SpringMVC/servlet/getDateSubjectById/1

	@GetMapping(value = "getDateSubjectById/{idSub}")
	@ResponseBody
	public Date getDateSubject(@PathVariable("idSub") int subjectId){

		return subjectService.getDateSubject(subjectId);

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


}
