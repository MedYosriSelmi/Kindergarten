package tn.kindergarten.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.LikesSub;

@Repository
public interface LikesSubRepository extends CrudRepository<LikesSub, Integer>  {

}
