package tn.kindergarten.services;

import java.util.Date;
import java.util.List;

import tn.kindergarten.entities.Planning;
import tn.kindergarten.entities.User;

public interface IPlanningService {

	    //public int AddPlanning(Planning plan);
	    public void DeletePlanning(int idPlan);
	    public int addUser(User user);
	    public void UpdatePlanning(int planId,String Departure, String Destination);
	    public List <Planning> listPlannings();
	    public List<Planning> searchPlanningByDate(Date date);
		public long getTotalPlannings();
		public void sendSMSforUser(int idUser); 
		//public void AddPlanning(Planning pub, int idUser, int idKind);
		public void AddPlanning(String Departure, String Destination, Date Time, int idKind, int idUser);

}
