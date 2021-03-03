package tn.kindergarten.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Event implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String Name;
	
	private String Description;
	
	@Temporal(TemporalType.DATE)
	private Date DateOfEvent;
	
	private String Photo;
	
	@OneToMany(mappedBy="event")
	private  List<ListParticipants> list_participants;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Kindergarten kindergarten;
	
	public Event() {}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getDateOfEvent() {
		return DateOfEvent;
	}

	public void setDateOfEvent(Date dateOfEvent) {
		DateOfEvent = dateOfEvent;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

	public List<ListParticipants> getList_participants() {
		return list_participants;
	}

	public void setList_participants(List<ListParticipants> list_participants) {
		this.list_participants = list_participants;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Kindergarten getKindergarten() {
		return kindergarten;
	}


	public void setKindergarten(Kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}

	

	
	
	

}
