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

import tn.kindergarten.entities.Message;
import tn.kindergarten.service.IMessageService;

@RestController
public class RestControlMessage {
	
	@Autowired
	IMessageService messageService;
	
		// http://localhost:8081/SpringMVC/servlet/addMessage
	
		@PostMapping("/addMessage")
		@ResponseBody
		public void addMessage(@RequestBody Message message){
			
			messageService.addMessage(message);
			
		}
		
		
		// http://localhost:8081/SpringMVC/servlet/getAllMessages

		@GetMapping("/getAllMessages")
		@ResponseBody
		public List<Message> getAllMessage(){
			
			return messageService.getAllMessages();
			
		}
		
		// http://localhost:8081/SpringMVC/servlet/deleteMessage/1
		
		@DeleteMapping("/deleteMessage/{messageId}")
		@ResponseBody
		public void deleteMessage(@PathVariable ("Message") int messageId){
			
			messageService.deleteMessage(messageId);
		}
		
		// http://localhost:8081/SpringMVC/servlet/updateMessage/1
		
		@PutMapping("/updateMessage/{messageId}")
	  	@ResponseBody
	  	public ResponseEntity<String> updateMessage(@RequestBody Message message,@PathVariable("messageId")int messageId) {
			
			messageService.updateMessage(message,messageId);
	  	    return new ResponseEntity<String>("Message updated successfully",HttpStatus.OK);
	  		
		}
		

}
