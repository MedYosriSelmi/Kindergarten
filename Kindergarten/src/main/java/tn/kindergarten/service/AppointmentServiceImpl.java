package tn.kindergarten.service;



import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
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
	@Autowired
	EmailSenderService emailSenderService ;
    
	

	@Override
	public List<Appointment> getAllAppointment() {
		return (List<Appointment>) appointments.findAll();
	}

	public String ajouter_Doctor_rendezVous(int id_user , int id_doctor ,Appointment appointment) {
		User DoctorId = users.findById(id_doctor).orElse(null);
		User UserId = users.findById(id_user).orElse(null);
		if (DoctorId.getRole().toString()!="Doctor") { return ("id_doctor n'est pas valide");	}
		if (UserId.getRole().toString()=="Parent") {
			
			
	List<String> compteur= new ArrayList<String>();
	for (Appointment appointment1 : appointments.find_date_appointment_byDoctor(appointment.getDate(),DoctorId.getId())) {
				compteur.add(appointment1.getBeginhour());
			}
				if(compteur.contains(appointment.getBeginhour()))
				{
				return	("hour existe");

				}
				else 
				{ 
					
					
				appointment.setDoctor(DoctorId);
				appointment.setUser(UserId);
			    appointment.setStatus(0);
	           appointment.setEndhour(Integer.toString(Integer.parseInt(appointment.getBeginhour()) +1));
					 Appointment appointment2 = appointments.save(appointment);
			      return ("   " +appointment2);
				
				}
}
			
				else
				{
					return ("user n'est pas parent");
					}
		}
	public String lister_date_disponible_byDoctor(int user_id,int id_Doctor,String date) throws ParseException  {
		
		
		User Doctor = users.findById(id_Doctor).orElse(null);
		User UserId = users.findById(user_id).orElse(null);
		if (Doctor.getRole().toString()!="Doctor"){
			return ("id_doctor n'est pas valide");
		}
		if (UserId.getRole().toString()=="Parent") {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse(date);
		List<Integer> hour= new ArrayList<Integer>();
		hour.add(8);hour.add(9); hour.add(10);hour.add(11);hour.add(12);hour.add(13);hour.add(14);hour.add(15);hour.add(16);
		
		for (Appointment app : appointments.find_date_appointment_byDoctor(d,Doctor.getId())) {
			System.out.println("*************"+Integer.parseInt(app.getBeginhour()));
			if( hour.contains(Integer.parseInt(app.getBeginhour()) ))
			{
				System.out.println("***************************");
				hour.remove(hour.indexOf(Integer.parseInt(app.getBeginhour())) );
		}
}
		return ( ("  "+ hour));
		}
		else
		{
			return ("user n'est pas parent");
			}
		}
		
					
	
	public String delete_appointment(int user_id,int id_appointment) {
		User UserId = users.findById(user_id).orElse(null);
	Appointment appointment = appointments.findById(id_appointment).orElse(null);
	if(appointment == null) {return ("appointment n'existe pas");}
		if (UserId.getRole().toString()=="Parent" ) {
	        if (UserId.getId()==appointment.getUser().getId()){
		
			appointments.deleteById(appointment.getId());
			return ("appointment est supprimé");	
		}
		
	else
		{
			return  ("Supprision non autorisée");
		}}
		
	else
		{
			return  ("user n'est pas parent");
        }
		
	}
	
	public String update_appointment_By_User(int user_id , int appointment_id,Appointment appointment) {
		User UserId = users.findById(user_id).orElse(null);
		
			 Appointment appointment_To_Update =appointments.findById(appointment_id).orElse(null);
			if  ( appointment_To_Update == null) {
					return ("appointment n'existe pas");
				
				}
			
			 if (UserId.getId()==appointment_To_Update.getUser().getId()){
			 if ( appointment_To_Update != null) {
				
				appointment_To_Update.setBeginhour(appointment.getBeginhour());
				appointment_To_Update.setDate(appointment.getDate());
				appointment_To_Update.setDescription(appointment.getDescription());
				appointment_To_Update.setEndhour(Integer.toString(Integer.parseInt(appointment.getBeginhour()) +1));
				appointment_To_Update.setStatus(0);

				
				appointments.save(appointment_To_Update);
				return ("appointment est bien modifiée ");
			 }
			
			}
			 
			else
			{
				return  ("Modification non autorisée");
			}
			return null;
			 
			 
}
			 
	public String update_appointment_By_Doctor(int doctor_id , int appointment_id,Appointment appointment) {
		User Doctor = users.findById(doctor_id).orElse(null);
		
		 Appointment appointment_To_Update =appointments.findById(appointment_id).orElse(null);
	
		if  ( appointment_To_Update == null) {
			return ("appointment n'existe pas");
		
		}
	
	 if (Doctor.getId()==appointment_To_Update.getDoctor().getId()){
	 if ( appointment_To_Update != null) {
			appointment_To_Update.setBeginhour(appointment.getBeginhour());
			appointment_To_Update.setDate(appointment.getDate());
			appointment_To_Update.setDescription(appointment.getDescription());
			appointment_To_Update.setEndhour(Integer.toString(Integer.parseInt(appointment.getBeginhour()) +1));
			appointment_To_Update.setStatus(1);
			
			
			appointments.save(appointment_To_Update);
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(appointment_To_Update.getUser().getEmail());
			mailMessage.setSubject("!! appointment Information !!");
			mailMessage.setFrom("kinder.garten0206@gmail.com");
			mailMessage.setText(" Dear Mr "+appointment_To_Update.getUser().getFirstName()+"  "+appointment_To_Update.getUser().getLastName()+
								"    your appointment is  updated ,  in  "+appointment_To_Update.getDate()+ "  at  "+appointment_To_Update.getBeginhour());

			emailSenderService.sendEmail(mailMessage);
			
			
			return ("appointment est bien modifiée ");
		} }
	 
	 else
		{
			return  ("Modification non autorisée");
		}
		return null;
		 
}
	public String searchappointment(int user_id,String search) {
	
		
			List<Appointment> appointment_search =appointments.searchappointment(search);
	
				return (""+appointment_search);

			}
	
	public String getallappointment_status_1(int id_medecin) {
		User Doctor = users.findById(id_medecin).orElse(null);
		
		
		List<Appointment> appointment = new ArrayList<>();
		List<Appointment> appointments2 = (List<Appointment>) appointments.findAll();
		
		
		for (Appointment app : appointments2) {
			if(app.getStatus() == 1 && Doctor.getId()==app.getDoctor().getId())
			{
				appointment.add(app);
			}
		}
		return ("" +appointment);
		}
	public String accepte_appointment(int Doctor_id,int id_appointment) {
		
		User Doctor = users.findById(Doctor_id).orElse(null);
		Appointment appointment = appointments.findById(id_appointment).orElse(null);
		 if (Doctor.getId()==appointment.getDoctor().getId()){
			if(appointment.getStatus() == 0)
			{
				appointment.setStatus(1);
				
				
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setTo(appointment.getUser().getEmail());
				mailMessage.setSubject("!! appointment Information !!");
				mailMessage.setFrom("kinder.garten0206@gmail.com");
				mailMessage.setText(" Dear Mr "+appointment.getUser().getFirstName()+"  "+appointment.getUser().getLastName()+
									"    your appointment is  accepted ,  in  "+appointment.getDate()+ "  at  "+appointment.getBeginhour());

				emailSenderService.sendEmail(mailMessage);
				appointments.save(appointment);
				return ("appointment est  accépté");


			}
			else
			{
				return ("appointment est  déja vaildé");

			}
		 } else {return (" tu n' as pas le droit  d'Accepter des rendez-vous pour d'autres personnes  ");}
}

	public String refut_appointment(int Doctor_id,int id_appointment) {
		User Doctor = users.findById(Doctor_id).orElse(null);
		
		Appointment appointment = appointments.findById(id_appointment).orElse(null);
		 if (Doctor.getId()==appointment.getDoctor().getId()){
			if(appointment.getStatus() == 0)
			{
				
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setTo(appointment.getUser().getEmail());
				mailMessage.setSubject("!! appointment Information !!");
				mailMessage.setFrom("kinder.garten0206@gmail.com");
				mailMessage.setText(" Dear Mr "+appointment.getUser().getFirstName()+"  "+appointment.getUser().getLastName()+
									"    your appointment is  not  accepted ,  in  "+appointment.getDate());

				emailSenderService.sendEmail(mailMessage);
				
				
				appointments.deleteById(appointment.getId());
				return ("appointment est réfusé");

			}
			else{
				return ("appointment est accepté deja");

			}

		 } else {return (" tu n' as pas le droit  de refuser des rendez-vous pour d'autres personnes  ");}
	}
	

		



	@Override
	public List<Appointment> searchappointment(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appointment> find_appointment_byparent(int parent_id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Appointment> find_date_appointment_byDoctor(java.sql.Date date, int doctor_id) {
		// TODO Auto-generated method stub
		return null;
	}



	

	


	

}
