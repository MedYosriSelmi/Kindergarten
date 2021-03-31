package tn.kindergarten.services;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.entities.Planning;
import tn.kindergarten.entities.Role;
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
	/*
	@Override
	public int AddPlanning(Planning plan) {
		planRep.save(plan);
		return plan.getId();

	}
	*/
	
	@Override
	public void AddPlanning(Planning plan, int idUser, int idKind) {
		User usr= userRep.findById(idUser).orElse(null);
		List<User> listusr = kindergartenRep.findById(idKind).get().getUser();
		for (User us:listusr )
		{
			if ((usr.getId() == us.getId() ) && (usr.getRole().equals(Role.Driver)) && (usr.isActif()==true))
			{
				//plan.getKidergarten().getLocation();
				planRep.save(plan);
		}}
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
	
	
	@Override
	public List<Planning> searchPlanningByDate(Date date) {
		LocalDate d = LocalDate.now();
		Date dateToday = java.sql.Date.valueOf(d);
		if(date.after(dateToday)){
			System.out.println("You can't select this date... Please try again!");
		}
		return planRep.searchPlanningByDate(date);
		
	}
	
	
	@Override
	public long getTotalPlannings() {
		long nb;
		nb = planRep.getTotalPlannings();
		return nb;
	}
	/*
	@Override
	public void sendSMS(int idUser, String body) {
		User u = userRep.findById(idUser).orElse(null);
		if(!u.getRole().equals(Role.Driver)){
			String number = u.getPhone();
		    Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
		    Message message = Message.creator(new PhoneNumber(number), new PhoneNumber(FROM_NUMBER), body).create();
		}
		else
			System.out.println("This is Admin Account .. Please Check It Again");
	}
	
	*/

}
