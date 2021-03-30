package tn.kindergarten.services;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import tn.kindergarten.entities.Planning;
import tn.kindergarten.entities.User;

public interface IPlanningService {

	    public int AddPlanning(Planning plan);
	    public void DeletePlanning(int idPlan);
	    public int addUser(User user);
	    public void UpdatePlanning(int planId,String destination);
	    public List <Planning> listPlannings();
	    //public List<Planning> searchPlanningByDate(Date date);
		public long getTotalPlannings();

}
