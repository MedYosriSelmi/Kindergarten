package tn.kindergarten.services;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.kindergarten.entities.Reclamation;
import tn.kindergarten.repository.ReclamationRepository;

@Service
public class ReclamationService implements IReclamationService {
	
	@Autowired
	ReclamationRepository recRep;

	@Override
	public int AddReclamation(Reclamation reclamation) {
		// TODO Auto-generated method stub
		recRep.save(reclamation);
		return reclamation.getId();
	}
	
	@Override
	public void DeleteReclamation(int idRec) {
		// TODO Auto-generated method stub
		Reclamation reclamation = recRep.findById(idRec).orElse(null);
		recRep.delete(reclamation);
	}

	@Override
	public Reclamation getreclamationById(int reclamationId) {
		// TODO Auto-generated method stub
        Reclamation rec = recRep.findById(reclamationId).orElse(null);
	    return rec;
	}

	@Override
	public long getNombreReclamation() {
		// TODO Auto-generated method stub
		long nbReclamation;
		nbReclamation = recRep.getNombreReclamation();
		return nbReclamation;
	}

	@Override
	public List<Reclamation> listReclamations() {
		// TODO Auto-generated method stub
		return (List<Reclamation>) recRep.findAll();
	}

	@Override
	public List<Reclamation> getallReclamationsbyKindergarten(int idKinder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reclamation> getallReclamationsbyUser(int idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reclamation> FiltrerReclamationsByDateJPQL(Date d1, Date d2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void UpdateReclamation(int reclamationId, String description, String photo) {
		// TODO Auto-generated method stub
		Reclamation rec = recRep.findById(reclamationId).orElse(null);
		rec.setDescription(description);
		rec.setPhoto(photo);
		recRep.save(rec);
	}

}
