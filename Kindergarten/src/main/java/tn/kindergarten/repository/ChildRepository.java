package tn.kindergarten.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.Child;



@Repository
public interface ChildRepository extends CrudRepository<Child, Integer> {
	@Query("SELECT count (*)  from Child c where c.user.id=:user AND c.kindergarten.id=:kindergarten")
	public long getNumberOfChildForUserInKinderJPQL(@Param("user") int user,@Param("kindergarten") int kindergarten);
}
