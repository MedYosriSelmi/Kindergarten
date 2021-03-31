package tn.kindergarten.service;

import java.util.Date;
import java.util.List;


public interface ILikesSubService {
	
	public void addLikesSub(int idUser, int idSubject);
	public List<Integer> getAllUserIdsBySujectId(int subjectId);
	public List<Integer> getAllSubjectIdsByUserId(int userId);
	public void deleteLikesSubById(int idUser, int idSubject);
	public int nbrLikesPerSubject(int subjectId);
	public int nbrLikesPerUser(int userId);
	public int getLikesPerUserByDate(Date date, int userId);
}
  