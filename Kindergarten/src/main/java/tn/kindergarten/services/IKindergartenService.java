package tn.kindergarten.services;

import tn.kindergarten.entities.Kindergarten;
import tn.kindergarten.entities.User;
import java.util.List;

public interface IKindergartenService {

	    public int AddKindergarten(Kindergarten kindergarten);
	    public void DeleteKindergarten(int idKindergarten);
	    public Kindergarten getKindergartenById(int KindergartenId);
	    public int addUser(User user);
	    public void UpdateKindergarten(int KindergartenId,String description,String photo);
	    public  List <Kindergarten> listKindergartens();
		public long getTotalKindergartens() ;
		//public List<Kindergarten> OrderPrice(Float price);
		public List<Kindergarten> findByPrice();






}
