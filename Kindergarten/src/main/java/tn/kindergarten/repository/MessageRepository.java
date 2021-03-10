package tn.kindergarten.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.Message;



@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {

}
