package tn.kindergarten.repository;





import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.Appointment;



@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {


	
	@Query("SELECT m FROM Appointment m WHERE m.Description LIKE %:search%  OR m.date LIKE %:search% OR m.Beginhour LIKE %:search% ")
	List<Appointment> searchappointment(@Param("search") String search);
	
	@Query("select a  from Appointment a  join a.user  u WHERE  u.id =:parent_id")
	List<Appointment> find_appointment_byparent(@Param("parent_id") int parent_id);
	
	@Query("select a  from Appointment a  join a.doctor g WHERE  a.date =:date and g.id =:doctor_id and status='1'")
	List<Appointment> find_date_appointment_byDoctor(@Param("date") java.util.Date date,@Param("doctor_id") int doctor_id);


}

