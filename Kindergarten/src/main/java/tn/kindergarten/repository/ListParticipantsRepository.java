package tn.kindergarten.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.Event;
import tn.kindergarten.entities.ListParticipants;
import tn.kindergarten.entities.User;



@Repository
public interface ListParticipantsRepository extends CrudRepository<ListParticipants, Integer> {
	
	@Query("select DISTINCT e from User e "
			+ "join e.list_participants l "
			+ "join l.event m "
			+ "where m.id=:eventId")
public List<User> getAllUserByEvent(@Param("eventId")int eventId);
	
	@Query("select DISTINCT e from Event e "
			+ "join e.list_participants l "
			+ "join l.user m "
			+ "where m.id=:userId")
public List<Event> getAllEventByUser(@Param("userId")int userId);


}
