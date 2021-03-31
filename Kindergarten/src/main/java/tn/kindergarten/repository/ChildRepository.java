package tn.kindergarten.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.Child;


@Repository
public interface ChildRepository extends CrudRepository<Child, Integer> {
	
	@Query("select DISTINCT c from Child c "
			+ "join User u "
			+ "where u.id=:userId")
public List<Child> getAllChildByUser(@Param("userId")int userId);
	
	@Query("select DISTINCT c from Child c "
			+ "join Kindergarten k "
			+ "where k.id=:kinderId")
public List<Child> getAllChildByKindergarten(@Param("kinderId")int kinderId);
}
