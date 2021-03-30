package tn.kindergarten.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.kindergarten.services.ILikesPubService;

@RestController
@RequestMapping("/LikesPub")
public class LikesPubController {
	
	@Autowired
	ILikesPubService likesPubService;
	
	
	// http://localhost:8081/SpringMVC/servlet/addLikesSub/1/1
	@PostMapping("/addLikesPub/{userId}/{pubId}")
	@ResponseBody
	public void addLikesPub(@PathVariable ("userId") int userId, @PathVariable("pubId") int pubId){

		likesPubService.addLikesPub(userId, pubId);

	}
	
	
	@GetMapping("/getUserIdByPublicationId/{pubId}")
	@ResponseBody
	public List<Integer> getUserIdBySujectId(@PathVariable ("pubId") int pubId) {
		
		return likesPubService.getAllUserIdsByPublicationId(pubId);
		
	}
	
	@GetMapping("/getPublicationIdByUserId/{userId}")
	@ResponseBody
	public List<Integer> getPublicationIdByUserId(@PathVariable ("userId") int userId) {
		
		return likesPubService.getAllPublicationIdsByUserId(userId);
		
	}
	
	@DeleteMapping("/deleteLike/{userId}/{pubId}")
	@ResponseBody
	public void deleteLike(@PathVariable ("userId") int userId, @PathVariable ("pubId") int pubId){
		
		likesPubService.deleteLikesPubById(userId, pubId);
		
	}

}
