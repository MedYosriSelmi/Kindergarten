package tn.kindergarten.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.kindergarten.entities.Reclamation;
import tn.kindergarten.entities.Status;

@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation, Integer>  {

	@Query(value="SELECT COUNT(*) FROM reclamation",nativeQuery = true) //OK
	long getNombreReclamation();
	
	@Query("SELECT r FROM Reclamation r "
			+ "WHERE r.Type =:type AND "
			+ "r.DateOfReclam >=:d1 AND "
			+ "r.DateOfReclam <=:d2") //OK
	List<Reclamation> FiltrerReclamationsByDateAndType(@Param("type") String type, @Param("d1") Date d1, @Param("d2") Date d2);
	
	@Query("SELECT r FROM Reclamation r "
			+ "WHERE r.Status =:status AND "
			+ "r.DateOfReclam >=:d1 AND "
			+ "r.DateOfReclam <=:d2") //OK
	List<Reclamation> FiltrerReclamationsByDateAndStatus(@Param("status") Status status, @Param("d1") Date d1, @Param("d2") Date d2);
	
	@Query("SELECT r FROM Reclamation r WHERE r.Status =:status ORDER BY r.DateOfReclam ASC") 
	List<Reclamation> getListReclamationsByStatusSorted(@Param("status") Status status);
	
	@Query("SELECT r FROM Reclamation r INNER JOIN r.user u WHERE u.id =:user_id")
	List<Reclamation> getallReclamationsByUserId(@Param("user_id") int user_id);
	
	@Query("SELECT r FROM Reclamation r INNER JOIN r.kindergarten k WHERE k.id =:kindergarten_Id")
	List<Reclamation> getallReclamationsByKindergartenId(@Param("kindergarten_Id") int kindergarten_Id);
	
	@Query("SELECT r FROM Reclamation r WHERE r.Type =:type AND r.Status IN :status") //OK
	List<Reclamation> getallReclamationsByTypeAndStatus(@Param("type") String type,@Param("status") Status status);
}








