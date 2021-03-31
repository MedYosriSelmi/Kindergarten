package tn.kindergarten.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	 
	/*
	@Override
	public void AddPublication(String description, MultipartFile photo, int idUser, int idKind) throws IllegalStateException, IOException {
		Publication pub = new Publication();
		User usr= userRep.findById(idUser).orElse(null);
		List<User> listusr = kindergartenRep.findById(idKind).get().getUser();
		for (User us:listusr )
		{
			if (usr.getId() == us.getId())
			{
				pub.setDescription(description);
				String filename = photo.getOriginalFilename();
			    photo.transferTo(new File("C:\\Users\\amara\\git\\Kindergarten\\Kindergarten\\PicturesPublications\\"+photo.getOriginalFilename()));
				pub.setPhoto(filename);
				
		}}
	}
	*/
	@Override
	public void AddPublication(int idUser, int idKind, String description, MultipartFile photo) throws IllegalStateException, IOException {
		Publication pub = new Publication();
		User usr= userRep.findById(idUser).orElse(null);
		List<User> listusr = kindergartenRep.findById(idKind).get().getUser();
		for (User us:listusr )
		{
			if (usr.getId() == us.getId())
			{
				pub.setDescription(description);
				String filename = photo.getOriginalFilename();
			    photo.transferTo(new File("C:\\Users\\amara\\git\\Kindergarten\\Kindergarten\\PicturesKindergarten\\Publications\\"+photo.getOriginalFilename()));
				pub.setPhoto(filename);
				
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
	public void UpdatePublication(int pubId, String description, MultipartFile photo) throws IllegalStateException, IOException {
		Publication pub = pubRep.findById(pubId).orElse(null);
		pub.setDescription(description);
		String filename = photo.getOriginalFilename();
	    photo.transferTo(new File("C:\\Users\\amara\\git\\Kindergarten\\Kindergarten\\PicturesPublications\\"+photo.getOriginalFilename()));
		pub.setPhoto(filename);
		pubRep.save(pub);
	}

	@Override
	public List<Publication> listPublications() {
		return (List<Publication>) pubRep.findAll();
	}
	

}
