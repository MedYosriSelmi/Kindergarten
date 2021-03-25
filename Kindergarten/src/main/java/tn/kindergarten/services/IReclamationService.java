package tn.kindergarten.services;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import tn.kindergarten.entities.Kindergarten;
import tn.kindergarten.entities.Reclamation;
import tn.kindergarten.entities.Status;
import tn.kindergarten.entities.User;

public interface IReclamationService {
	public void AddReclamation(int idUser, String description, String date, String type, Status status, MultipartFile file) throws IllegalStateException, IOException; 
	public void UpdateReclamation(int reclamationId,String description, MultipartFile file) throws IllegalStateException, IOException; 
	public List<Reclamation> listReclamations(); 
	public void DeleteReclamation(int idRec); 
    public int addUser(User user); 
    public void DeleteUser(int idUser);
    public User getUserById(int userId); 
    public int addKindergarten(Kindergarten kindergarten); 
    public Reclamation getreclamationById(int reclamationId); 
    public long getTotalReclamation(); 
    public List<Reclamation> getListReclamationsByStatusSorted(Status status);
    public List<Reclamation> getallReclamationsByTypeAndStatus(String type, Status status); 
    public List<Reclamation> getallReclamationsByKindergartenId(int KindergartenId); 
    public List<Reclamation> getallReclamationsByUserId(int UserId); 
    public List<Reclamation> FiltrerReclamationsByDateAndType(String type, Date d1, Date d2); 
    public List<Reclamation> FiltrerReclamationsByDateAndStatus(Status status, Date d1, Date d2); 
    public List<Reclamation> CombinedSearchReclamation(String keyword);
    public void sendSMSforUser(int idUser, String body); 
}
