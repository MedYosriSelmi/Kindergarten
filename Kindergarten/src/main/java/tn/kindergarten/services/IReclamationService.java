package tn.kindergarten.services;

import java.util.Date;
import java.util.List;
import tn.kindergarten.entities.Kindergarten;
import tn.kindergarten.entities.Reclamation;
import tn.kindergarten.entities.Status;
import tn.kindergarten.entities.User;

public interface IReclamationService {
	public int AddReclamation(Reclamation reclamation); //DONE
	public void UpdateReclamation(int reclamationId,String description,String photo); //DONE
	public void DeleteReclamation(int idRec); //DONE
    public int addUser(User user); //DONE
    public User getUserById(int userId); //DONE
    public int addKindergarten(Kindergarten kindergarten); //DONE
    public void InsertReclamationUser(int reclamationId, int UserId); //DONE
    public void InsertReclamationKindergarten(int reclamationId, int kindergartenId); //DONE
    public Reclamation getreclamationById(int reclamationId); //DONE
    public long getNombreReclamation(); //DONE
    public List<Reclamation> listReclamations(); //DONE
    public List<Reclamation> getListReclamationsByStatusSorted(Status status);
    public List<Reclamation> getallReclamationsByTypeAndStatus(String type, Status status); //DONE
    public List<Reclamation> getallReclamationsByKindergartenId(int KindergartenId); //NO
    public List<Reclamation> getallReclamationsByUserId(int UserId); //NO
    public List<Reclamation> FiltrerReclamationsByDateAndType(String type, Date d1, Date d2); //DONE
    public List<Reclamation> FiltrerReclamationsByDateAndStatus(Status status, Date d1, Date d2); //DONE
}
