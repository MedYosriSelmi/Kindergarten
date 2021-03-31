package tn.kindergarten.repository;

import java.util.Date;
//import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.LikesSub;

@Repository
public interface LikesSubRepository extends CrudRepository<LikesSub, Integer> {

	@Query("select DISTINCT u.id from User u " + "join u.likes_subs l " + "join l.sub s " + "where s.id=:subjectId")
	public List<Integer> getAllUserIdsBySubjectId(@Param("subjectId") int subjectId);

	@Query("select DISTINCT s.id from Subject s " + "join s.likes_sub l " + "join l.user u " + "where u.id=:userId")
	public List<Integer> getAllSubjectIdsByUserId(@Param("userId") int userId);

	@Query("Select count(*) from LikesSub l " + "where l.DateLikeSub=:dateL and " + "l.user.id=:userId")
	public int getLikesSubPerUserByDate(@Param("dateL") Date dateLike, @Param("userId") int userId);

	@Query("SELECT count(*) FROM LikesSub l where (l.sub.id =:subjectId)")
	public int nbrLikesPerSubject(@Param("subjectId") int subjectId);

	@Query("SELECT count(*) FROM LikesSub l where (l.user.id =:userId)")
	public int nbrLikesPerUser(@Param("userId") int userId);

}
