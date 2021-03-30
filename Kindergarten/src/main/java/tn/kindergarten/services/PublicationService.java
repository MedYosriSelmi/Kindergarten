package tn.kindergarten.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.kindergarten.entities.Publication;
import tn.kindergarten.entities.User;
import tn.kindergarten.repository.KindergartenRepository;
import tn.kindergarten.repository.PublicationRepository;
import tn.kindergarten.repository.UserRepository;

@Service
public class PublicationService implements IPublicationService {
	
	@Autowired
	PublicationRepository pubRep;
	@Autowired
	UserRepository userRep;
	@Autowired
	KindergartenRepository kindergartenRep;
	 /*
	@Override
	public int AddPublication(Publication pub) {
		pubRep.save(pub);
		return pub.getId();
	}*/
	
	@Override
	public void AddPublication(Publication pub, int idUser, int idKind) {
		User usr= userRep.findById(idUser).orElse(null);
		List<User> listusr = kindergartenRep.findById(idKind).get().getUser();
		for (User us:listusr )
		{
			if (usr.getId() == us.getId())
			{
		pubRep.save(pub);
		}}
	}
	
	@Override
	public void DeletePublication(int idpub) {
		Publication pub = pubRep.findById(idpub).orElse(null);
		pubRep.delete(pub);
	}

	@Override
	public int addUser(User user) {
		userRep.save(user);
		return user.getId();
	}
	
	@Override
	public void UpdatePublication(int pubId, String description, String photo) {
		Publication pub = pubRep.findById(pubId).orElse(null);
		pub.setDescription(description);
		pub.setPhoto(photo);
		pubRep.save(pub);
	}

	@Override
	public List<Publication> listPublications() {
		return (List<Publication>) pubRep.findAll();
	}
	

}
