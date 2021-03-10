package tn.kindergarten.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.User;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
