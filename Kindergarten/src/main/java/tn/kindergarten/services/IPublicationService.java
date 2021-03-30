package tn.kindergarten.services;

import java.util.List;


import tn.kindergarten.entities.Publication;
import tn.kindergarten.entities.User;

public interface IPublicationService {
	
        public void AddPublication(Publication pub, int idUser, int idKind);
	    //public int AddPublication(Publication pub);
	    public void DeletePublication(int idPub);
	    public int addUser(User user);
	    public void UpdatePublication(int pubId,String description,String photo);
	    public  List <Publication> listPublications();
}
