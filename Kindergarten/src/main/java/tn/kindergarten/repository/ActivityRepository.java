package tn.kindergarten.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.Activity;



@Repository
public interface ActivityRepository extends CrudRepository<Activity, Integer> {

}
