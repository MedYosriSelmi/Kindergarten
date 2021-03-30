package tn.kindergarten.services;

import org.springframework.stereotype.Service;

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
	public int AddKindergarten(Kindergarten kindergarten) {
		kindergartenRep.save(kindergarten);
		return kindergarten.getId();
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
	public void UpdateKindergarten(int KindergartenId, String description, String photo) {
		Kindergarten kindergarten = kindergartenRep.findById(KindergartenId).orElse(null);
		kindergarten.setDescription(description);
		kindergarten.setPhoto(photo);
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
	/*
	@Override
	public List<Kindergarten> OrderPrice(Float Price) {
		
		return (List<Kindergarten>) kindergartenRep.OrderPrice(Price);
	}*/
	
	@Override
	public List<Kindergarten> findByPrice(){
	return (List<Kindergarten>)	kindergartenRep.findByPrice();
	}

}
