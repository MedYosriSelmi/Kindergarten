package tn.kindergarten.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.entities.LikesPub;
import tn.kindergarten.entities.LikesPubPK;
import tn.kindergarten.repository.LikesPubRepository;
import tn.kindergarten.repository.PublicationRepository;

@Service
public class LikesPubService implements ILikesPubService {
	
	@Autowired
	LikesPubRepository likesPubRepository;
	@Autowired
	PublicationRepository pubRepository;
	
	@Override
	public void addLikesPub(int idUser, int idPub) {
		
		LikesPubPK likesPubPk = new LikesPubPK();
		likesPubPk.setIdUser(idUser);
		likesPubPk.setIdPub(idPub);
		
		LikesPub likesPub = new LikesPub();
		likesPub.setLikespubPK(likesPubPk);
		likesPubRepository.save(likesPub);
	}

	@Override
	public void deleteLikesPubById(int idUser, int idPub) {
		
		List<LikesPub> l = (List<LikesPub>) likesPubRepository.findAll();
		for (LikesPub object:l){
			if ( object.getUser().getId()==idUser){
				if (object.getPub().getId()==idPub)
					likesPubRepository.delete(object);
			}
				
		}
		
	}

	@Override
	public List<Integer> getAllUserIdsByPublicationId(int pubId) {
		
		return likesPubRepository.getAllUserIdsByPubId(pubId);
		
	}

	@Override
	public List<Integer> getAllPublicationIdsByUserId(int userId) {
		
		return likesPubRepository.getAllPublicationIdsByUserId(userId);
	}
	
}
