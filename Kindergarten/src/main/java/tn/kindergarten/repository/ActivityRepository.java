package tn.kindergarten.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.Activity;



@Repository
public interface ActivityRepository extends CrudRepository<Activity, Integer> {
	
	@Query("SELECT count (*) from Activity")
	public int getNombreActivityJPQL();
	@Query("SELECT Name	 from Activity")
	public List<String> getAllActivityNamesJPQL();
	 @Query("SELECT DISTINCT activity from Activity activity where activity.Name=:name ")
	public Activity getActivity(@Param("name")String name);
}
