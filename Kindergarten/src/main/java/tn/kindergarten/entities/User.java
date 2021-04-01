package tn.kindergarten.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
public class User implements Serializable {

	
	/**
	 * 
	 */
	@JsonIgnore
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnore
	private String FirstName;
	
	@JsonIgnore
	private String LastName;
	
	@JsonIgnore
	@NotNull
	private String Email;
	
	@JsonIgnore
	private String Password;
	
	@JsonIgnore
	private String Phone;
	
	@JsonIgnore
	private boolean isActif;
	
	@JsonIgnore
	@Temporal(TemporalType.DATE)
	private Date DateOfBirth;
	
	@JsonIgnore
	private String Photo;
	
	@JsonIgnore
	private String Adress;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<ListParticipants> list_participants;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<LikesSub> likes_subs;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<LikesPub> likes_pubs;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Subject> list_subject;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Reclamation> list_reclams;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Publication> list_pub;
	
	@JsonIgnore
	@ManyToMany(mappedBy="user",fetch=FetchType.EAGER )
	private List<Kindergarten> kindergartens;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Event> list_events;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Comment> comments;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Child> list_child;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Bill> list_fact;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Appointment> list_appoint;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Activity> list_act;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Planning> list_plan;
	
	@JsonIgnore
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





	public List<Kindergarten> getKindergartens() {
		return kindergartens;
	}



	public void setKindergartens(List<Kindergarten> kindergartens) {
		this.kindergartens = kindergartens;
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
