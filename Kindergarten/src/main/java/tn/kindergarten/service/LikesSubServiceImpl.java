package tn.kindergarten.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.entities.LikesSub;
import tn.kindergarten.entities.LikesSubPK;
import tn.kindergarten.repository.LikesSubRepository;
import tn.kindergarten.repository.SubjectRepository;

@Service
public class LikesSubServiceImpl implements ILikesSubService {

	
	@Autowired
	LikesSubRepository likesSubRepository;
	@Autowired
	SubjectRepository subjectRepository;
	
	@Override
	public void addLikesSub(int idUser, int idSubject) {
		
		LikesSubPK likesSubPk = new LikesSubPK();
		likesSubPk.setIdUser(idUser);
		likesSubPk.setIdSub(idSubject);
		
		LikesSub likesSub = new LikesSub();
		likesSub.setLikessubPK(likesSubPk);
		likesSubRepository.save(likesSub);
	}

	@Override
	public void deleteLikesSubById(int idUser, int idSubject) {
		
		List<LikesSub> l = (List<LikesSub>) likesSubRepository.findAll();
		for (LikesSub object:l){
			if ( object.getUser().getId()==idUser){
				if (object.getSub().getId()==idSubject)
					likesSubRepository.delete(object);
			}
				
		}
		
	}

	@Override
	public List<Integer> getAllUserIdsBySujectId(int subjectId) {
		
		return likesSubRepository.getAllUserIdsBySubjectId(subjectId);
		
	}

	@Override
	public List<Integer> getAllSubjectIdsByUserId(int userId) {
		
		return likesSubRepository.getAllSubjectIdsByUserId(userId);
	}

	@Override
	public int nbrLikesPerSubject(int subjectId) {
		return likesSubRepository.nbrLikesPerSubject(subjectId);
	}

	@Override
	public int nbrLikesPerUser(int userId) {
		return likesSubRepository.nbrLikesPerUser(userId);
	}

	@Override
	public int getLikesPerUserByDate(Date date, int userId) {
		
		return likesSubRepository.getLikesSubPerUserByDate(date, userId);
		
	}

	

}
