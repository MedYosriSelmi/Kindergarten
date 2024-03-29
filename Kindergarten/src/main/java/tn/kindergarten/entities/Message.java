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
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	
	private String Description;

	@Temporal(TemporalType.DATE)
	private Date DateDelivered;
	
	@ManyToOne
	private User Sender;
	
	@ManyToOne
	private User Reciever;
	
	public Message () {}


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

	public Date getDateDelivered() {
		return DateDelivered;
	}

	public void setDateDelivered(Date dateDelivered) {
		DateDelivered = dateDelivered;
	}


	public User getSender() {
		return Sender;
	}


	public void setSender(User sender) {
		Sender = sender;
	}


	public User getReciever() {
		return Reciever;
	}


	public void setReciever(User reciever) {
		Reciever = reciever;
	}


	
	
	
	
	
}
