package tn.kindergarten.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.Appointment;



@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

}
