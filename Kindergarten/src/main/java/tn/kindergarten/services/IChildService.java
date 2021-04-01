package tn.kindergarten.services;



import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tn.kindergarten.entities.Child;




public interface IChildService {
	//public int ajouterChild(Child child,long idUser,int idkinder);
	public void deleteChildById(int childId);
	List<Child> getAllChild();
	List<Child> getAllChildByKindergarten(int kinderId);
	public List<Child> getAllChildByUserr(long userId);
	public void updateChild(Child c, int childId);
	public int ajouterChild(long idUser,int idkinder ,String date,String name,MultipartFile file);
	//public int modifyChild(long idUser,int idkinder ,String date,String name,MultipartFile file);
}
