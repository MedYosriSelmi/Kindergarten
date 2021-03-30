package tn.kindergarten.services;

import java.util.List;

public interface ILikesPubService {
	
	public void addLikesPub(int idUser, int idPub);
	public void deleteLikesPubById(int idUser, int idPub);
	public List<Integer> getAllUserIdsByPublicationId(int pubId);
	public List<Integer> getAllPublicationIdsByUserId(int userId);
	
	

}
