package tn.kindergarten.service;


import java.sql.Date;
import java.util.List;



import com.sun.el.parser.ParseException;

import tn.kindergarten.entities.Appointment;

public interface IAppointmentService {

	public List<Appointment> getAllAppointment();
	public String ajouter_Doctor_rendezVous( int id_doctor,int id_user , Appointment appointment);
	public String update_appointment_By_User(int user_id , int appointment_id,Appointment appointment);
	public String update_appointment_By_Doctor(int doctor_id , int appointment_id,Appointment appointment);
	public String lister_date_disponible_byDoctor(int user_id,int id_Doctor,String date) throws ParseException, java.text.ParseException ;
	public String delete_appointment(int user_id,int id_appointment);
    public String searchappointment(int user_id,String search);
	public String getallappointment_status_1(int id_medecin);
	public String accepte_appointment(int Doctor_id,int id_appointment);
	public String refut_appointment(int Doctor_id,int id_appointment);
    List<Appointment> searchappointment( String search);
	List<Appointment> find_date_appointment_byDoctor(Date date,int doctor_id);
	
}
