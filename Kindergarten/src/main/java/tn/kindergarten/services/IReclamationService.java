package tn.kindergarten.services;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import tn.kindergarten.entities.Reclamation;
import tn.kindergarten.entities.Status;
import tn.kindergarten.entities.User;

public interface IReclamationService { 
	public void addReclamation(int idUser,int idKinder,  String description, String date, String type, Status status, MultipartFile file) throws IllegalStateException, IOException; 
	public void updateReclamation(int idUser, int reclamationId,String description, MultipartFile file) throws IllegalStateException, IOException; 
	public List<Reclamation> listReclamations(); 
	public void deleteReclamation(int idUser, int idRec); 
    public User getUserById(int userId);  
    public long getTotalReclamation();
    public long getNbNewReclamation();
    public long getNbPendingReclamation(); 
    public Reclamation getreclamationById(int reclamationId);
    public List<Reclamation> getListReclamationsByStatusSorted(Status status);
    public List<Reclamation> getallReclamationsByKindergartenId(int KindergartenId); 
    public List<Reclamation> getallReclamationsByUserId(int UserId); 
    public List<Reclamation> FiltrerReclamationsByDateAndType(String type, Date d1, Date d2); 
    public List<Reclamation> FiltrerReclamationsByDateAndStatus(Status status, Date d1, Date d2); 
    public List<Reclamation> getallReclamationsByTypeAndStatus(String type, Status status);
    public List<Reclamation> combinedSearchReclamation(String keyword);
    public List<Reclamation> searchReclamationByDate(Date date);
    public void NotifyUserBySMS(int idUser, int idRec); 
}
