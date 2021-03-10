package tn.kindergarten.sevices;




import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void ajouterLP(int userId, int eventId, Date dateP) {
		ListParticipantsPK LPPK = new ListParticipantsPK();
		LPPK.setIdUser(userId);
		LPPK.setIdEvent(eventId);
		LPPK.setDateParticipation(dateP);
		
		
		ListParticipants LP = new ListParticipants();
		LP.setListparticipantsPK(LPPK);
		ListParticipantsrep.save(LP);
		
		
	}

	@Override
	public List<User> getAllUserByEvent(int eventId) {
		return ListParticipantsrep.getAllUserByEvent(eventId);
	}

	@Override
	public List<Event> getAllEventByUser(int userId) {
		return ListParticipantsrep.getAllEventByUser(userId);
	}
    
	
	
	


	
		
		
	
    
	
		
	

	
	

}
