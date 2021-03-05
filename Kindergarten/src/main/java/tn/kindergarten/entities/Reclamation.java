package tn.kindergarten.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reclamation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String Description;
	
	@Temporal(TemporalType.DATE)
	private Date DateOfReclam;
	
	private String Type;
	
	private String Status;
	
	private String Photo;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Kindergarten kindergarten;
	
	
	public Reclamation () {}
	
	public Reclamation(String description, Date dateOfReclam, String type, String status, String photo) {
		super();
		Description = description;
		DateOfReclam = dateOfReclam;
		Type = type;
		Status = status;
		Photo = photo;
	}

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

	public Date getDateOfReclam() {
		return DateOfReclam;
	}

	public void setDateOfReclam(Date dateOfReclam) {
		DateOfReclam = dateOfReclam;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
