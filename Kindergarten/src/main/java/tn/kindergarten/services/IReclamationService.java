package tn.kindergarten.services;

import java.util.Date;
import java.util.List;
import tn.kindergarten.entities.Reclamation;

public interface IReclamationService {
	public int AddReclamation(Reclamation reclamation);
	public void DeleteReclamation(int idRec);
    public Reclamation getreclamationById(int reclamationId);
    public long getNombreReclamation();
    public List<Reclamation> listReclamations();
    public List<Reclamation> getallReclamationsbyKindergarten(int idKinder);
    public List<Reclamation> getallReclamationsbyUser(int idUser);
    public void UpdateReclamation(int reclamationId,String description,String photo);
    public List<Reclamation> FiltrerReclamationsByDateJPQL(Date d1,Date d2);
}
