package tn.kindergarten.sevices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import tn.kindergarten.entities.Activity;
import tn.kindergarten.entities.Category;
import tn.kindergarten.entities.Kindergarten;
import tn.kindergarten.entities.User;
import tn.kindergarten.repository.ActivityRepository;
import tn.kindergarten.repository.KindergartenRepository;
import tn.kindergarten.repository.UserRepository;


@Service
public class ActivityService implements IActivityService {

	
	@Autowired
	ActivityRepository Activityrep;
	@Autowired
	KindergartenRepository kinderrep;
	@Autowired
	UserRepository userrep;
	

	
	@Override
	public ResponseEntity<String>  ajoutActivity(Activity activity, int kinderId, int userId, MultipartFile file) {
		Kindergarten k =kinderrep.findById(kinderId).orElse(null);
		User u =userrep.findById(userId).orElse(null);
		if (u.getRole().toString()=="Childcare_Manger" ){
		activity.setKindergarten(k);
		activity.setUser(u);

		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
			try {
				activity.setPhoto(Base64.getEncoder().encodeToString(file.getBytes()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
			Activityrep.save(activity);
			return  ResponseEntity.ok("Activity added successfully");
		}
			return ResponseEntity.ok ("ajout non autorisé");
			}

	
	
	
	@Override
	public List<Activity> getAllActivity() {
		return (List<Activity>)Activityrep.findAll();
	}

	@Override
	public void deleteActivityById(int ActivityId) {
		Activity a =Activityrep.findById(ActivityId).orElse(null);
		Activityrep.delete(a);
		
	}

	@Override
	public int getNombreActivityJPQL() {
		return Activityrep.getNombreActivityJPQL();
	}

	@Override
	public List<String> getAllActivityNamesJPQL() {
		return Activityrep.getAllActivityNamesJPQL();
	
	}

	@Override
	public void updateActivity(Activity a, int idActivity,MultipartFile file) {
		Activity activity = Activityrep.findById(idActivity).get();
		activity.setDateOfActivity(a.getDateOfActivity());
		activity.setDescription(a.getDescription());
		activity.setName(a.getName());
		activity.setCategory(a.getCategory());
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
			try {
				activity.setPhoto(Base64.getEncoder().encodeToString(file.getBytes()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		Activityrep.save(activity);
			
		
	}

	@Override
	public Activity getActivity(String name) {
		return Activityrep.getActivity(name);
	
	}

	

	@Override
	public void assignAttachementToPost(int id, MultipartFile file) {
		Activity p =Activityrep.findById(id).orElse(null);
		if (p!=null){
			p.setPhoto(file.getOriginalFilename());
			Activityrep.save(p);
		}

}

	@Override
	public List<Activity> getAllActivityByCategorie(Category category) {
		return Activityrep.getAllActivityByCategorie(category);
	}

	@Override
	public List<Activity> search(String keyword) {
		 if (keyword != null) {
            return Activityrep.search(keyword);
    }
	return (List<Activity>)Activityrep.findAll();
	
}

	@Override
	public List<Activity> activities() {
		
		return Activityrep.activitiesall();
	}

	@Override
	public List<Activity> paginationsorting(Integer pageNo, Integer pageSize, String sortBy) {
		
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
	 
	        Page<Activity>pagedResult = Activityrep.findAll(paging);
	         
	        if(pagedResult.hasContent()) {
	            return pagedResult.getContent();
	        } else {
	            return new ArrayList<Activity>();
	        }
	    }

	@Override
	public List<Activity> getAllActivityPourToday() {
		return Activityrep.getAllActivityPourToday();
	}

	@Override
	public List<Activity> getAllActivityOrdonneParDate() {
		return Activityrep.getAllActivityOrdonneParDate();
	}

	
	
	

	
}



	
