package tn.kindergarten.services;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.entities.Planning;
import tn.kindergarten.entities.User;
import tn.kindergarten.repository.KindergartenRepository;
import tn.kindergarten.repository.PlanningRepository;
import tn.kindergarten.repository.UserRepository;

@Service
public class PlanningService implements IPlanningService {
	

	@Autowired
	PlanningRepository planRep;
	@Autowired
	UserRepository userRep;
	@Autowired
	KindergartenRepository kindergartenRep;
	
	@Override
	public int AddPlanning(Planning plan) {
		planRep.save(plan);
		return plan.getId();
	}
	@Override
	public void DeletePlanning(int idplan) {
		Planning plan = planRep.findById(idplan).orElse(null);
		planRep.delete(plan);
	}

	@Override
	public int addUser(User user) {
		userRep.save(user);
		return user.getId();
	}
	
	@Override
	public void UpdatePlanning(int planId, String destination) {
		Planning plan = planRep.findById(planId).orElse(null);
		plan.setDestination(destination);
		planRep.save(plan);
	}

	@Override
	public List<Planning> listPlannings() {
		return (List<Planning>) planRep.findAll();
	}
	
	/*
	@Override
	public List<Planning> searchPlanningByDate(Date date) {
		LocalDateTime d = LocalDateTime.now();
		Date dateToday = java.sql.Timestamp.valueOf(d);
		if(date.after(dateToday )){
			System.out.println("You can't select this date... Please try again!");
		}
		return planRep.searchPlanningByDate(date);
		
		
	}
	*/
	
	@Override
	public long getTotalPlannings() {
		long nb;
		nb = planRep.getTotalPlannings();
		return nb;
	}
	
	
	
	

}
