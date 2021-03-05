package tn.kindergarten.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.Reclamation;



@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation, Integer>  {

	@Query(value="SELECT COUNT(*) FROM reclamation",nativeQuery = true)
	long getNombreReclamation();
	
}
