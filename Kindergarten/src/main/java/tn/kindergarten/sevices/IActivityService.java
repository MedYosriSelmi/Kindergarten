package tn.kindergarten.sevices;

import java.util.List;



import tn.kindergarten.entities.Activity;


public interface IActivityService {
	public int ajouterActivity(Activity Activity);
	public List<Activity> getAllActivity();
	public void deleteActivityById(int ActivityId);
	public int getNombreActivityJPQL();
	public List<String> getAllActivityNamesJPQL();
	public void updateActivity(Activity a, int idActivity);
	public Activity getActivity(String name);
	public void kindergartenaActivity( int kinderId , int ActivityId);
	public void useraactivity(int userId, int ActivityId);

}
