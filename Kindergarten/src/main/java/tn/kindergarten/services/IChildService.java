package tn.kindergarten.services;



import java.util.List;

import tn.kindergarten.entities.Child;




public interface IChildService {
	public int ajouterChild(Child child);
	public void deleteChildById(int childId);
	public void updateChild(Child c, int idChild);
	List<Child> getAllChild();
	void affecterChildAUser(int userId, int ChildId);
	void affecterChildAKindergarten(int userId, int kindergartenId);
	List<Child> getAllChildByUser(int userId);
	List<Child> getAllChildByKindergarten(int kinderId);
	
	
	
	
}
