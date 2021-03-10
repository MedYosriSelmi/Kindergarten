package tn.kindergarten.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.LikesPub;



@Repository
public interface LikesPubRepository extends CrudRepository<LikesPub, Integer>  {

}
