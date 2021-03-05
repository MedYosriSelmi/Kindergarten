package tn.kindergarten.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.ListParticipants;



@Repository
public interface ListParticipantsRepository extends CrudRepository<ListParticipants, Integer> {

}
