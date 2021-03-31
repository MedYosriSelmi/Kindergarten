package tn.kindergarten.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.kindergarten.entities.Child;
import tn.kindergarten.repository.ChildRepository;
import tn.kindergarten.repository.KindergartenRepository;
import tn.kindergarten.repository.UserRepository;


@Service
public class ChildServiceImpl implements IChildService {

	@Autowired
	ChildRepository childrepo;
	@Autowired
	UserRepository userrepo;
	@Autowired
	KindergartenRepository kinderrepo;
	
	@Override
	public int ajouterChild(Child child) {
		childrepo.save(child);
		return child.getId();
	}

	@Override
	public void deleteChildById(int childId) {
		Child child = childrepo.findById(childId).get();
		childrepo.delete(child);
	}
	
	@Override
	public void updateChild(Child c, int idChild) {
		Child child = childrepo.findById(idChild).get();
		child.setDateOfBirth(c.getDateOfBirth());
		child.setName(c.getName());
		child.setPhoto(c.getPhoto());
		childrepo.save(child);
	}
	
	@Override
	public List<Child> getAllChild() {
		return (List<Child>) childrepo.findAll();
	}
	/*
	@Override
	public void affecterChildAUser( int userId , int ChildId) {
        User u =userrepo.findById(userId).orElse(null);
		Child c =childrepo.findById(ChildId).orElse(null);
		c.setUser(u);
		childrepo.save(c);
	}
	
	@Override
	public void affecterChildAKindergarten( int userId , int kindergartenId) {
        User u =userrepo.findById(userId).orElse(null);
		Kindergarten k =kinderrepo.findById(kindergartenId).orElse(null);
		k.setUser(u);
		kinderrepo.save(k);
	}
	*/
	@Override
	public List<Child> getAllChildByUser(int userId) {
		return childrepo.getAllChildByUser(userId);
	}
	
	@Override
	public List<Child> getAllChildByKindergarten(int kinderId) {
		return childrepo.getAllChildByKindergarten(kinderId);
	}

	@Override
	public void affecterChildAUser(int userId, int ChildId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void affecterChildAKindergarten(int userId, int kindergartenId) {
		// TODO Auto-generated method stub
		
	}

}
