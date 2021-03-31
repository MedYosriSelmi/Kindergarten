package tn.kindergarten.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.kindergarten.service.ILikesSubService;

@RestController
public class RestControlLikesSub {

	@Autowired
	ILikesSubService likesSubService;

	// http://localhost:8081/SpringMVC/servlet/addLikesSub/1/1
	@PostMapping("/addLikesSub/{userId}/{subjectId}")
	@ResponseBody
	public void addLikesSub(@PathVariable("userId") int userId, @PathVariable("subjectId") int subjectId) {

		likesSubService.addLikesSub(userId, subjectId);

	}

	@GetMapping("/getUserIdBySujectId/{subjectId}")
	@ResponseBody
	public List<Integer> getUserIdBySujectId(@PathVariable("subjectId") int subjectId) {

		return likesSubService.getAllUserIdsBySujectId(subjectId);

	}

	@GetMapping("/getSubjectIdByUserId/{userId}")
	@ResponseBody
	public List<Integer> getSubjectIdByUserId(@PathVariable("userId") int userId) {

		return likesSubService.getAllSubjectIdsByUserId(userId);

	}

	@DeleteMapping("/deleteLike/{userId}/{subjectId}")
	@ResponseBody
	public void deleteLike(@PathVariable("userId") int userId, @PathVariable("subjectId") int subjectId) {

		likesSubService.deleteLikesSubById(userId, subjectId);

	}

	@GetMapping("/nbrLikesPerSubject/{subjectId}")
	@ResponseBody
	public int nbrLikesPerSubject(@PathVariable("subjectId") int subjectId) {

		return likesSubService.nbrLikesPerSubject(subjectId);

	}

	@GetMapping("/nbrLikesPerUser/{userId}")
	@ResponseBody
	public int nbrLikesPerUser(@PathVariable("userId") int userId) {

		return likesSubService.nbrLikesPerUser(userId);

	}

	@GetMapping("/getLikesPerUserByDate/{userId}/{date}")
	@ResponseBody
	public int getLikesPerUserByDate(@PathVariable("userId") int userId,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {

		return likesSubService.getLikesPerUserByDate(date, userId);

	}

}
