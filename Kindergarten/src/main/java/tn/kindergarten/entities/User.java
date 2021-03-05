package tn.kindergarten.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;

@Entity
public class User implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String FirstName;
	
	private String LastName;
	@NotNull
	private String Email;
	
	private String Password;
	
	private String Phone;
	
	private boolean isActif;
	
	@Temporal(TemporalType.DATE)
	private Date DateOfBirth;
	
	private String Photo;
	
	private String Adress;
	
	@OneToMany(mappedBy="user")
	private List<ListParticipants> list_participants;
	
	@OneToMany(mappedBy="user")
	private List<LikesSub> likes_subs;
	
	@OneToMany(mappedBy="user")
	private List<LikesPub> likes_pubs;
	
	@OneToMany(mappedBy="user")
	private List<Subject> list_subject;
	
	@OneToMany(mappedBy="user")
	private List<Reclamation> list_reclams;
	
	@OneToMany(mappedBy="user")
	private List<Publication> list_pub;
	
	
	@OneToMany(mappedBy="user")
	private List<Kindergarten> list_kindergartens;
	
	@OneToOne(mappedBy="userkinder")
	private Kindergarten kindergarten;
	
	@OneToMany(mappedBy="user")
	private List<Event> list_events;
	
	@OneToMany(mappedBy="user")
	private List<Comment> comments;
	
	@OneToMany(mappedBy="user")
	private List<Child> list_child;
	
	@OneToMany(mappedBy="user")
	private List<Bill> list_fact;
	
	@OneToMany(mappedBy="user")
	private List<Appointment> list_appoint;
	
	@OneToMany(mappedBy="user")
	private List<Activity> list_act;
	
	@OneToMany(mappedBy="user")
	private List<Planning> list_plan;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public User () 
	{
		
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public boolean isActif() {
		return isActif;
	}

	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}

	public Date getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}



	public String getPassword() {
		return Password;
	}



	public void setPassword(String password) {
		Password = password;
	}



	public String getPhone() {
		return Phone;
	}



	public void setPhone(String phone) {
		Phone = phone;
	}



	public String getPhoto() {
		return Photo;
	}



	public void setPhoto(String photo) {
		Photo = photo;
	}



	public String getAdress() {
		return Adress;
	}



	public void setAdress(String adress) {
		Adress = adress;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}



	public List<ListParticipants> getList_participants() {
		return list_participants;
	}



	public void setList_participants(List<ListParticipants> list_participants) {
		this.list_participants = list_participants;
	}



	public List<LikesSub> getLikes_subs() {
		return likes_subs;
	}



	public void setLikes_subs(List<LikesSub> likes_subs) {
		this.likes_subs = likes_subs;
	}



	public List<LikesPub> getLikes_pubs() {
		return likes_pubs;
	}



	public void setLikes_pubs(List<LikesPub> likes_pubs) {
		this.likes_pubs = likes_pubs;
	}



	public List<Subject> getList_subject() {
		return list_subject;
	}



	public void setList_subject(List<Subject> list_subject) {
		this.list_subject = list_subject;
	}



	public List<Reclamation> getList_reclams() {
		return list_reclams;
	}



	public void setList_reclams(List<Reclamation> list_reclams) {
		this.list_reclams = list_reclams;
	}



	public List<Publication> getList_pub() {
		return list_pub;
	}



	public void setList_pub(List<Publication> list_pub) {
		this.list_pub = list_pub;
	}



	



	public List<Kindergarten> getList_kindergartens() {
		return list_kindergartens;
	}



	public void setList_kindergartens(List<Kindergarten> list_kindergartens) {
		this.list_kindergartens = list_kindergartens;
	}



	public Kindergarten getKindergarten() {
		return kindergarten;
	}



	public void setKindergarten(Kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}



	public List<Event> getList_events() {
		return list_events;
	}



	public void setList_events(List<Event> list_events) {
		this.list_events = list_events;
	}



	public List<Comment> getComments() {
		return comments;
	}



	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}



	public List<Child> getList_child() {
		return list_child;
	}



	public void setList_child(List<Child> list_child) {
		this.list_child = list_child;
	}



	public List<Bill> getList_fact() {
		return list_fact;
	}



	public void setList_fact(List<Bill> list_fact) {
		this.list_fact = list_fact;
	}



	public List<Appointment> getList_appoint() {
		return list_appoint;
	}



	public void setList_appoint(List<Appointment> list_appoint) {
		this.list_appoint = list_appoint;
	}



	public List<Activity> getList_act() {
		return list_act;
	}



	public void setList_act(List<Activity> list_act) {
		this.list_act = list_act;
	}



	public List<Planning> getList_plan() {
		return list_plan;
	}



	public void setList_plan(List<Planning> list_plan) {
		this.list_plan = list_plan;
	}



	

	

	



	
	
	
	
	
	
}
