package tn.kindergarten.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.Planning;



@Repository
public interface PlanningRepository extends CrudRepository<Planning, Integer> {

	@Query("SELECT p FROM Planning p WHERE p.time =:date") 
	public List<Planning> searchPlanningByDate(@Param("date") Date date); 

	@Query(value="SELECT COUNT(*) FROM planning",nativeQuery=true) 
	long getTotalPlannings();
}


