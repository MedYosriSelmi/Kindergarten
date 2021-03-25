package tn.kindergarten.services;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
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

	@Value("${TWILIO_ACCOUNT_SID}")
    private String ACCOUNT_SID;

    @Value("${TWILIO_AUTH_TOKEN}")
    private String AUTH_TOKEN;

    @Value("${FROM_NUMBER}")
    private String FROM_NUMBER;
    
	@Override
	public void AddReclamation(int idUser, String description, String date, String type, Status status, MultipartFile file) throws IllegalStateException, IOException {
		User user = userRep.findById(idUser).get();
		/*List<Kindergarten> liste = user.getKindergartens();
		for(Kindergarten kind : liste){
			
		}*/
		Reclamation reclamation = new Reclamation();
		String filename=reclamation.getId() + file.getOriginalFilename();
	    file.transferTo(new File("C:\\Users\\MONDHER\\Documents\\STS\\Kindergarten\\Kindergarten\\Images\\"+file.getOriginalFilename()));
		reclamation.setDescription(description);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    try {
			reclamation.setDateOfReclam(formatter.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		reclamation.setType(type);
		reclamation.setStatus(status);
		reclamation.setPhoto(filename);
		//reclamation.setKindergarten(kindergarten);
		reclamation.setUser(user);
		recRep.save(reclamation);
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
	public long getTotalReclamation() {
		long nbReclamation;
		nbReclamation = recRep.getTotalReclamation();
		return nbReclamation;
	}

	@Override
	public List<Reclamation> listReclamations() {
		return (List<Reclamation>) recRep.findAll();
	}

	@Override
	public List<Reclamation> getallReclamationsByKindergartenId(int KindergartenId) { 
		return recRep.getallReclamationsByKindergartenId(KindergartenId);
	}

	@Override
	public List<Reclamation> getallReclamationsByUserId(int UserId) { 
		return recRep.getallReclamationsByUserId(UserId);
	}

	@Override
	public void UpdateReclamation(int reclamationId, String description,  MultipartFile file) throws IllegalStateException, IOException {
		Reclamation rec = recRep.findById(reclamationId).orElse(null);
		if(rec.getStatus()==Status.Pending || rec.getStatus()==Status.New)
		{
			rec.setDescription(description);
			String filename=rec.getId() + file.getOriginalFilename();
		    file.transferTo(new File("C:\\Users\\MONDHER\\Documents\\STS\\Kindergarten\\Kindergarten\\Images\\"+file.getOriginalFilename()));
			rec.setPhoto(filename);
			recRep.save(rec);
		}
		else {
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

	@Override
	public List<Reclamation> CombinedSearchReclamation(String keyword) {
		return recRep.SearchReclamationByType(keyword);
	}

	@Override
	public void sendSMSforUser(int idUser, String body) {
		User u = userRep.findById(idUser).orElse(null);
		String number = u.getPhone();
		Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
		Message message = Message.creator(new PhoneNumber(number), new PhoneNumber(FROM_NUMBER), body).create();
	}

	@Override
	public void DeleteUser(int idUser) {
		User user = userRep.findById(idUser).orElse(null);
		userRep.delete(user);
	}

}


