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

import tn.kindergarten.entities.Comment;
import tn.kindergarten.service.ICommentService;

@RestController
public class RestControlComment {
	
	@Autowired
	ICommentService commentService;
	
	
	// http://localhost:8081/SpringMVC/servlet/addComment
	
	@PostMapping("/addComment")
	@ResponseBody
	public void addComment(@RequestBody Comment comment){
		
		commentService.addComment(comment);
		
	}
	
	
	// http://localhost:8081/SpringMVC/servlet/getAllComments

	@GetMapping("/getAllComments")
	@ResponseBody
	public List<Comment> getAllComments(){
		
		return commentService.getAllComments();
		
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
