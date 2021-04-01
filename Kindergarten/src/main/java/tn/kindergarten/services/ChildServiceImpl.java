package tn.kindergarten.services;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



import tn.kindergarten.entities.Child;
import tn.kindergarten.entities.Kindergarten;
import tn.kindergarten.entities.User;
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
	public int ajouterChild(long idUser,int idkinder ,String date,String name,MultipartFile file) {
		Child child = new Child();
		String filename=file.getOriginalFilename();
		try {
			file.transferTo(new File("C:\\Users\\Med Yosri\\git\\Kindergarten\\images\\"+file.getOriginalFilename()));
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Kindergarten k = kinderrepo.findById(idkinder).orElse(null);
		User u = userrepo.findById(idUser).orElse(null);
		child.setUser(u);
		child.setKindergarten(k);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    try {
			child.setDateOfBirth(formatter.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    child.setName(name);
	    child.setPhoto(filename);
	    
		childrepo.save(child);
		return child.getId();
	}

	@Override
	public void deleteChildById(int childId) {
		Child child = childrepo.findById(childId).get();
		childrepo.delete(child);
	}
	
	
	@Override
	public List<Child> getAllChild() {
		return (List<Child>) childrepo.findAll();
	}
	
	
		
	@Override
	public List<Child> getAllChildByKindergarten(int kinderId) {
		return childrepo.getAllChildByKindergarten(kinderId);
	}

	

	@Override
	public List<Child> getAllChildByUserr(long userId) {
		return childrepo.getAllChildByUser(userId);
	}


	
	@Override
	public void updateChild(Child c, int childId) {
		Child child = childrepo.findById(childId).get();
		child.setName(c.getName());
		child.setDateOfBirth(c.getDateOfBirth());
		child.setPhoto(c.getPhoto());
		childrepo.save(child);

	}
	

	

}
