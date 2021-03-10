package tn.kindergarten.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.entities.Appointment;
import tn.kindergarten.entities.User;
import tn.kindergarten.repository.AppointmentRepository;
import tn.kindergarten.repository.UserRepository;
@Service
public  class AppointmentServiceImpl implements IAppointmentService {
	@Autowired
	AppointmentRepository appointments ;
	@Autowired
	UserRepository users ;
	
    @Override
	public int ajouterAppointment(Appointment appointment) {
		appointments.save(appointment);
		return appointment.getId();
	}

	@Override
	public void deleteAppointmentById(int appointmentId) {
		Appointment a  =appointments.findById(appointmentId).orElse(null);
		appointments.delete(a);		
	}
	

	@Override
	public List<Appointment> getAllAppointment() {
		return (List<Appointment>) appointments.findAll();
	}
	@Override
	public void affecterRDVaMedecin( int userId , int appointmentsId) {
        User u =users.findById(userId).orElse(null);
		Appointment e =appointments.findById(appointmentsId).orElse(null);
		e.setUser(u);
		appointments.save(e);
	}


 
	@Override
		public void updateAppointment(Appointment c, int idAppointment) {
			Appointment appointment = appointments.findById(idAppointment).get();
			appointment.setDateOfAppoint(c.getDateOfAppoint());
			appointment.setDescription(c.getDescription());
			appointment.setStatus(c.getStatus());
			appointments.save(appointment);
			
		}

	


	

}
