package tn.kindergarten.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.kindergarten.entities.Kindergarten;
import tn.kindergarten.entities.Reclamation;
import tn.kindergarten.entities.Status;
import tn.kindergarten.entities.User;
import tn.kindergarten.repository.KindergartenRepository;
import tn.kindergarten.repository.ReclamationRepository;
import tn.kindergarten.repository.UserRepository;

@Service
public class ReclamationService implements IReclamationService {
	
	@Autowired
	ReclamationRepository recRep;
	@Autowired
	UserRepository userRep;
	@Autowired
	KindergartenRepository kindRep;

	@Override
	public int AddReclamation(Reclamation reclamation) {
		recRep.save(reclamation);
		return reclamation.getId();
	}
	
	@Override
	public void DeleteReclamation(int idRec) {
		Reclamation reclamation = recRep.findById(idRec).orElse(null);
		recRep.delete(reclamation);
	}

	@Override
	public Reclamation getreclamationById(int reclamationId) {
        Reclamation rec = recRep.findById(reclamationId).orElse(null);
	    return rec;
	}

	@Override
	public long getNombreReclamation() {
		long nbReclamation;
		nbReclamation = recRep.getNombreReclamation();
		return nbReclamation;
	}

	@Override
	public List<Reclamation> listReclamations() {
		return (List<Reclamation>) recRep.findAll();
	}

	//YET
	@Override
	public List<Reclamation> getallReclamationsByKindergartenId(int KindergartenId) { 
		return recRep.getallReclamationsByKindergartenId(KindergartenId);
	}

	//YET
	@Override
	public List<Reclamation> getallReclamationsByUserId(int UserId) { 
		return recRep.getallReclamationsByUserId(UserId);
	}

	@Override
	public void UpdateReclamation(int reclamationId, String description, String photo) {
		Reclamation rec = recRep.findById(reclamationId).orElse(null);
		if(rec.getStatus()==Status.Pending)
		{
			rec.setDescription(description);
			rec.setPhoto(photo);
			recRep.save(rec);
		}
		else{
			System.out.println("This reclamation was treated");
		}
	}

	@Override
	public int addUser(User user) {
		userRep.save(user);
		return user.getId();
	}
	
	@Override
	public User getUserById(int userId) {
		User u = userRep.findById(userId).orElse(null);
		return u;
	}

	@Override
	public int addKindergarten(Kindergarten kindergarten) {
		kindRep.save(kindergarten);
		return kindergarten.getId();
	}

	@Override
	public void InsertReclamationUser(int reclamationId, int UserId) {
		Reclamation r = recRep.findById(reclamationId).orElse(null);
		User u = userRep.findById(UserId).orElse(null);
		r.setUser(u);
		recRep.save(r);
	}

	@Override
	public void InsertReclamationKindergarten(int reclamationId, int kindergartenId) {
		Reclamation r = recRep.findById(reclamationId).orElse(null);
		Kindergarten k = kindRep.findById(kindergartenId).orElse(null);
		r.setKindergarten(k);
		recRep.save(r);
	}

	@Override
	public List<Reclamation> FiltrerReclamationsByDateAndType(String type, Date d1, Date d2) {
		List<Reclamation> liste = new ArrayList<>();
		liste = recRep.FiltrerReclamationsByDateAndType(type, d1, d2);
		return liste;
	}

	@Override
	public List<Reclamation> FiltrerReclamationsByDateAndStatus(Status status, Date d1, Date d2) {
		List<Reclamation> list = new ArrayList<>();
		list = recRep.FiltrerReclamationsByDateAndStatus(status, d1, d2);
		return list;
	}

	@Override
	public List<Reclamation> getallReclamationsByTypeAndStatus(String type, Status status) {
		return recRep.getallReclamationsByTypeAndStatus(type, status);
	}

	@Override
	public List<Reclamation> getListReclamationsByStatusSorted(Status status) {
		return recRep.getListReclamationsByStatusSorted(status);
	}

}
