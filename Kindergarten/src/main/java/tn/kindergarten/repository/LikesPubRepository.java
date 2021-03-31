package tn.kindergarten.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.LikesPub;
import tn.kindergarten.entities.Planning;



@Repository
public interface LikesPubRepository extends CrudRepository<LikesPub, Integer>  {
	
	@Query("select DISTINCT u.id from User u "
			+ "join u.likes_pubs l "
			+ "join l.pub p "
			+ "where p.id=:pubId")
public List<Integer> getAllUserIdsByPubId(@Param("pubId")int pubId);
	
	@Query("select DISTINCT p.id from Publication p "
			+ "join p.likes_pub l "
			+ "join l.user u "
			+ "where u.id=:userId")
public List<Integer> getAllPublicationIdsByUserId(@Param("userId")int userId);
	
	
	@Query("SELECT p FROM LikesPub p WHERE p.DateLikePub =:date") 
	public List<LikesPub> searchLikesPubByDate(@Param("date") Date date); 

}
