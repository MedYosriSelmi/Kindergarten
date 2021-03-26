package tn.kindergarten.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import tn.kindergarten.entities.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer>  {

}
