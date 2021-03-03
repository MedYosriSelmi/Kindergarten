package tn.kindergarten.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.Subject;



@Repository
public interface SubjectRepository extends CrudRepository<Subject, Integer> {

}
