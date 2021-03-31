package tn.kindergarten.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import tn.kindergarten.entities.Kindergarten;
import tn.kindergarten.entities.User;
import tn.kindergarten.repository.KindergartenRepository;
import tn.kindergarten.services.IKindergartenService;
import tn.kindergarten.repository.UserRepository;


@Service
public class KindergartenService implements IKindergartenService {
	
	@Autowired
	KindergartenRepository kindergartenRep;
	@Autowired
	UserRepository userRep;
	
	@Override
	public int AddKindergarten(String description, String email, String	location, String name, String phone, MultipartFile photo, Float pricePerChild) throws IllegalStateException, IOException {
		Kindergarten kind = new Kindergarten();
		kind.setDescription(description);
		kind.setEmail(email);
		kind.setLocation(location);
		kind.setName(name);
		kind.setPhone(phone);
		String filename = photo.getOriginalFilename();
	    photo.transferTo(new File("C:\\Users\\amara\\git\\Kindergarten\\Kindergarten\\PicturesKindergarten\\"+photo.getOriginalFilename()));
		kind.setPhoto(filename);
		kind.setPricePerChild(pricePerChild);
	    kindergartenRep.save(kind);
		return kind.getId();
	}
		
	@Override
	public void DeleteKindergarten(int idKindergarten) {
		Kindergarten kindergarten = kindergartenRep.findById(idKindergarten).orElse(null);
		kindergartenRep.delete(kindergarten);
	}

	@Override
	public Kindergarten getKindergartenById(int kindergartenId) {
		Kindergarten kindergarten = kindergartenRep.findById(kindergartenId).orElse(null);
	    return kindergarten;
	}
	@Override
	public int addUser(User user) {
		userRep.save(user);
		return user.getId();
	}
	
	@Override
	public void UpdateKindergarten(int KindergartenId, String description, MultipartFile photo) throws IllegalStateException, IOException {
		Kindergarten kindergarten = kindergartenRep.findById(KindergartenId).orElse(null);
		kindergarten.setDescription(description);
		String filename = photo.getOriginalFilename();
	    photo.transferTo(new File("C:\\Users\\amara\\git\\Kindergarten\\Kindergarten\\PicturesKindergarten\\"+photo.getOriginalFilename()));
	    kindergarten.setPhoto(filename);
		kindergartenRep.save(kindergarten);
	}


	@Override
	public List<Kindergarten> listKindergartens() {
		return (List<Kindergarten>) kindergartenRep.findAll();
	}
	
	@Transactional	
	public void affecterUserKindergarten(int userId, int kindId) {
		Kindergarten kind = kindergartenRep.findById(kindId).get();
		User user = userRep.findById(userId).get();

		if(kind.getUser() == null){

			List<User> usr = new ArrayList<>();
			usr.add(user);
			kind.setUser(usr);
		}else{

			kind.getUser().add(user);

		}

	}
	
	@Override
	public long getTotalKindergartens() {
		long nb;
		nb = kindergartenRep.getTotalKindergartens();
		return nb;
	}
	
	
	@Override
	public List<Kindergarten> SearchByPrice(Float price){
	return kindergartenRep.SearchByPrice(price);
	}

	@Override
	public List<Kindergarten> findByPrice(){
	return kindergartenRep.findByPrice();
	}



}
