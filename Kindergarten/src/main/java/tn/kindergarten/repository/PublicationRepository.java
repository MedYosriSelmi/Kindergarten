package tn.kindergarten.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.Publication;



@Repository
public interface PublicationRepository extends CrudRepository<Publication, Integer> {

}
