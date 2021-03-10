package tn.kindergarten.sevices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.entities.Activity;

import tn.kindergarten.entities.Kindergarten;
import tn.kindergarten.entities.User;
import tn.kindergarten.repository.ActivityRepository;
import tn.kindergarten.repository.KindergartenRepository;
import tn.kindergarten.repository.UserRepository;


@Service
public class ActivityService implements IActivityService {

	
	@Autowired
	ActivityRepository Activityrep;
	@Autowired
	KindergartenRepository kinderrep;
	@Autowired
	UserRepository userrep;
	@Override
	public int ajouterActivity(Activity Activity) {
		Activityrep.save(Activity);
		return Activity.getId();
	}

	@Override
	public List<Activity> getAllActivity() {
		return (List<Activity>)Activityrep.findAll();
	}

	@Override
	public void deleteActivityById(int ActivityId) {
		Activity a =Activityrep.findById(ActivityId).orElse(null);
		Activityrep.delete(a);
		
	}

	@Override
	public int getNombreActivityJPQL() {
		return Activityrep.getNombreActivityJPQL();
	}

	@Override
	public List<String> getAllActivityNamesJPQL() {
		return Activityrep.getAllActivityNamesJPQL();
	
	}

	@Override
	public void updateActivity(Activity a, int idActivity) {
		Activity activity = Activityrep.findById(idActivity).get();
		activity.setDateOfActivity(a.getDateOfActivity());
		activity.setDescription(a.getDescription());
		activity.setName(a.getName());
		Activityrep.save(activity);
			
		
	}

	@Override
	public Activity getActivity(String name) {
		return Activityrep.getActivity(name);
	
	}

	@Override
	public void kindergartenaActivity(int kinderId, int ActivityId) {
		Kindergarten k =kinderrep.findById(kinderId).orElse(null);
		Activity a =Activityrep.findById(ActivityId).orElse(null);
		a.setKindergarten(k);
		Activityrep.save(a);
		
	}

	@Override
	public void useraactivity(int userId, int ActivityId) {
		User u =userrep.findById(userId).orElse(null);
		Activity e =Activityrep.findById( ActivityId).orElse(null);
		e.setUser(u);
		Activityrep.save(e);
		
	}

}
