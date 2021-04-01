package tn.kindergarten.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.Kindergarten;

@Repository
public interface KindergartenRepository extends CrudRepository<Kindergarten, Integer> {
	
	
	@Query(value="SELECT COUNT(*) FROM kindergarten", nativeQuery=true) 
	long getTotalKindergartens();

	@Query("SELECT p FROM Kindergarten p ORDER BY p.PricePerChild ASC")
	public List<Kindergarten> findByPrice();

		
	@Query("SELECT k FROM Kindergarten k WHERE k.PricePerChild =:price") 
	List<Kindergarten> SearchByPrice(@Param("price") Float price); 
	
	/*
	@Query("SELECT k.Location FROM Kindergarten "
			+"join k.user u"
			+ "WHERE u.id=:id ")
	public String getLocationKind(@Param("id") int id);
	
*/
}
