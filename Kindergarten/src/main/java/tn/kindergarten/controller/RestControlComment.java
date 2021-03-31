package tn.kindergarten.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.kindergarten.entities.Comment;
import tn.kindergarten.service.ICommentService;

@RestController
public class RestControlComment {
	
	@Autowired
	ICommentService commentService;
	
	
	// http://localhost:8081/SpringMVC/servlet/addParentComment/1/1
	
	@PostMapping("/addParentComment/{subjectId}/{userId}")
	@ResponseBody
	public void addParentComment(@RequestBody Comment comment, @PathVariable("subjectId") int subjectId, @PathVariable("userId") int userId){
		
		commentService.addParentComment(comment,subjectId, userId);
		
	}
	
	// http://localhost:8081/SpringMVC/servlet/addChildComment/1/1/1
	
	@PostMapping("/addChildComment/{subjectId}/{userId}/{parentId}")
	@ResponseBody
	public void addChildComment(@RequestBody Comment comment, @PathVariable("subjectId") int subjectId, @PathVariable("userId") int userId, @PathVariable("parentId") int parentId) {
		
		commentService.addChildComment(comment, subjectId, userId, parentId);
		
	}
	
	
	// http://localhost:8081/SpringMVC/servlet/getCommentBySubjectId/1

	@GetMapping("/getCommentBySubjectId/{subjectId}")
	@ResponseBody
	public Set<String> getCommentBySubjectId(@PathVariable("subjectId") int subjectId){
		
		return commentService.getCommentBySubjectId(subjectId);
		
	}
	
	@GetMapping("/getCommentByParentId/{parentId}")
	@ResponseBody
	public Set<String> getCommentByParentId(@PathVariable("parentId")int parentId){
		
		return commentService.getCommentByParentId(parentId);
	}
	
	// http://localhost:8081/SpringMVC/servlet/deleteComment/1
	
	@DeleteMapping("/deleteComment/{commentId}")
	@ResponseBody
	public void deleteComment(@PathVariable ("commentId") int commentId){
		
		commentService.deleteComment(commentId);
	}
	
	// http://localhost:8081/SpringMVC/servlet/updateComment/1
	
	@PutMapping("/updateComment/{commentId}")
  	@ResponseBody
  	public ResponseEntity<String> updateComment(@RequestBody Comment comment,@PathVariable("commentId")int commentId) {
		
		commentService.updateComment(comment,commentId);
  	    return new ResponseEntity<String>("Comment updated successfully",HttpStatus.OK);
  		
	}
	

}
