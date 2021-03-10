package tn.kindergarten.service;


import java.util.List;

import tn.kindergarten.entities.Appointment;

public interface IAppointmentService {
	public int ajouterAppointment(Appointment appointment);
	public void deleteAppointmentById(int appointmentId);
	public List<Appointment> getAllAppointment();
	public void affecterRDVaMedecin( int userId , int appointmentsId) ;
	
	public void updateAppointment(Appointment c, int idAppointment);
}
