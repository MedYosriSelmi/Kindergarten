package tn.kindergarten.services;

import tn.kindergarten.entities.Kindergarten;
import tn.kindergarten.entities.User;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface IKindergartenService {

	    public void DeleteKindergarten(int idKindergarten);
	    public Kindergarten getKindergartenById(int KindergartenId);
	    public int addUser(User user);
	    public  List <Kindergarten> listKindergartens();
		public long getTotalKindergartens() ;
		public int AddKindergarten(String description, String email, String location, String name, String phone, MultipartFile photo, Float pricePerChild) throws IllegalStateException, IOException;
		public void UpdateKindergarten(int KindergartenId, String description, MultipartFile photo) throws IllegalStateException, IOException;
		public List<Kindergarten> SearchByPrice(Float price);
		public List<Kindergarten> findByPrice();






}
