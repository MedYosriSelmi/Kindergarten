package tn.kindergarten.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tn.kindergarten.entities.Publication;
import tn.kindergarten.entities.User;

public interface IPublicationService {
	
        //public void AddPublication(Publication pub, int idUser, int idKind);
	    //public int AddPublication(Publication pub);
	    public void DeletePublication(int idPub);
	    public int addUser(User user);
	    //public void UpdatePublication(int pubId,String description,String photo);
	    public  List <Publication> listPublications();
		//void AddPublication(String description, MultipartFile photo, int idUser, int idKind) throws IllegalStateException, IOException;
		void UpdatePublication(int pubId, String description, MultipartFile photo) throws IllegalStateException, IOException;
		void AddPublication(int idUser, int idKind, String description, MultipartFile photo)
				throws IllegalStateException, IOException;
		
}
