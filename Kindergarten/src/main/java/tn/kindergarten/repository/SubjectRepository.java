package tn.kindergarten.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Integer> {

	Set<Subject> findTop5ByOrderByCreationDateDesc();

	@Query("Select s from Subject s " + "where s.user.id=:userId")
	public List<Subject> getSubjectByUserId(@Param("userId") int userId);

}
