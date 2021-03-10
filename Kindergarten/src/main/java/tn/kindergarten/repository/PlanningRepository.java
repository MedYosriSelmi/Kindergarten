package tn.kindergarten.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.Planning;



@Repository
public interface PlanningRepository extends CrudRepository<Planning, Integer> {

}
