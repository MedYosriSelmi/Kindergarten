package tn.kindergarten.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.Kindergarten;

@Repository
public interface KindergartenRepository extends CrudRepository<Kindergarten, Integer> {
	
	
	@Query(value="SELECT COUNT(*) FROM kindergarten", nativeQuery=true) 
	long getTotalKindergartens();
	/*
	@Query("SELECT pricePerChild FROM Kindergarten p ORDER BY p.pricePerChild DESC")
	List<Kindergarten> OrderPrice();*/

	@Query(value="SELECT pricePerChild FROM Kindergarten p ORDER BY p.pricePerChild DESC", nativeQuery=true)
	List<Kindergarten> findByPrice();
		

}
