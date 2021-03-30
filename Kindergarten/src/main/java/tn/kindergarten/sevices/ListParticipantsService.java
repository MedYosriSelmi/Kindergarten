package tn.kindergarten.sevices;




import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.entities.Child;
import tn.kindergarten.entities.Event;

import tn.kindergarten.entities.ListParticipants;
import tn.kindergarten.entities.ListParticipantsPK;
import tn.kindergarten.entities.User;
import tn.kindergarten.repository.EventRepository;
import tn.kindergarten.repository.ListParticipantsRepository;
import tn.kindergarten.repository.UserRepository;



@Service
public class ListParticipantsService  implements IListParticipantsService{

	
	@Autowired
	ListParticipantsRepository ListParticipantsrep;
    @Autowired
    UserRepository userrep;
    @Autowired
    EventRepository eventrep;
    
	@Override
	public void Participer(int userId, int eventId) {
		ListParticipants l = ListParticipantsrep.annuler(userId, eventId);
		System.out.println(l);
		if(l.getEtat().equals("participé") &&l!=null){
			l.setEtat("annulé");
			ListParticipantsrep.save(l);	
			
		} else{
		ListParticipantsPK LPPK = new ListParticipantsPK();
		LPPK.setIdUser(userId);
		LPPK.setIdEvent(eventId);
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		LPPK.setDateParticipation(date);
		
		
		ListParticipants LP = new ListParticipants();
		LP.setListparticipantsPK(LPPK);
		LP.setEtat("participé");
	
		ListParticipantsrep.save(LP);
		}}
		
	

	@Override
	public List<User> getAllUserByEvent(int eventId) {
		return ListParticipantsrep.getAllUserByEvent(eventId);
	}

	@Override
	public List<Event> getAllEventByUser(int userId) {
		return ListParticipantsrep.getAllEventByUser(userId);
	}



	@Override
	public int getNombreParticipantsJPQL() {
		return ListParticipantsrep.getNombreParticipantsJPQL();
	}

	@Override
	public List<Child> getChildForUserInKinderJPQL(int user, int kindergarten) {
		
		return ListParticipantsrep.getChildForUserInKinderJPQL(user, kindergarten);
	}

	
		
	}

	
		
		
		
	

	
		
	

	
	
	
	


	
		
		
	
    
	
		
	

	
	


