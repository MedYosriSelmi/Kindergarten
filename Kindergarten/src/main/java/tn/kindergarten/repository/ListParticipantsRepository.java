package tn.kindergarten.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.kindergarten.entities.Child;
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
	
	@Query("SELECT count (*) from ListParticipants  where Etat='Participé'")
	public int getNombreParticipantsJPQL();
	
	
	@Query("SELECT a from ListParticipants a where a.user.id=:id AND a.event.id=:ide ")
	public ListParticipants annuler(@Param("id")int id,@Param("ide")int ide);		
	
	@Query("DELETE FROM  ListParticipants a where a.user.id=:id AND a.event.id=:ide") 
	public void deleteParticipationByiduserandIdevent(@Param("id")int id,@Param("ide")int ide);

	
	@Query("SELECT c  from Child c where c.user.id=:user AND c.kindergarten.id=:kindergarten")
	public List<Child> getChildForUserInKinderJPQL(@Param("user") int user,@Param("kindergarten") int kindergarten);

}
