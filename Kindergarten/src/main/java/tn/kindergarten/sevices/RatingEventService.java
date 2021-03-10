package tn.kindergarten.sevices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.entities.Event;
import tn.kindergarten.entities.Rating;
import tn.kindergarten.entities.User;
import tn.kindergarten.repository.EventRepository;
import tn.kindergarten.repository.IRatingEventRepository;
import tn.kindergarten.repository.UserRepository;
@Service
public class RatingEventService implements IRatingEventService{
	@Autowired
	IRatingEventRepository ratEventrep;
	
	@Autowired
	UserRepository userrepo;
	@Autowired
	EventRepository eventrepo;
	@Override
	public String addRatingEvent(int idUser, int idEvent, int ratingValue) {
		Rating rat = new Rating();
		User user = userrepo.findById(idUser).orElse(null);
		Event event =eventrepo.findById(idEvent).orElse(null);
		rat.setEventRat(event);
		rat.setUserRat(user);
		List<Rating> ratEvent= ratEventrep.findRatingEventByEventAndUser(idEvent, idUser);
		if(ratEvent.size()!=0) {
			rat.setRatId(ratEvent.get(0).getRatId());
			rat.setRatingValue(ratingValue);
			ratEvent.get(0).setRatingValue(ratingValue);			
			updateRatingEvent(ratEvent.get(0)); 
			return "Rating is updating successfully";
		}

		rat.setRatingValue(ratingValue);
		ratEventrep.save(rat);
		
		return "Rating is done successfully";
	}

	@Override
	public String updateRatingEvent(Rating ratEvent) {
		ratEventrep.save(ratEvent);
		return "successful update";
	}

	@Override
	public float getAvgRat() {
		return ratEventrep.getAvgOfValueRating();
	}

	@Override
	public float getValueRatingByEventAndUser(int idEvent, int idUser) {
		List<Rating> ratEvent= ratEventrep.findRatingEventByEventAndUser(idEvent, idUser);
		if(ratEvent.size()!=0) return ratEvent.get(0).getRatingValue();
		
		return getAvgRat();
	}

}
