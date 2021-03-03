package tn.kindergarten.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.Child;



@Repository
public interface ChildRepository extends CrudRepository<Child, Integer> {

}
