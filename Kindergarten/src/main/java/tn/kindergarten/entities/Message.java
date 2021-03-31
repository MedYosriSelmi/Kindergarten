package tn.kindergarten.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String Description;

	@Column(updatable = false, nullable = false)
	private Date creationDate;

	@Column(nullable = false)
	private Date lastUpdateDate;

	@ManyToOne
	private User Sender;

	@ManyToOne
	private User Reciever;

	public Message() {
	}

	@PrePersist
	protected void onCreate() {
		this.creationDate = new Date();
		this.lastUpdateDate = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.lastUpdateDate = new Date();
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Message(int id, String description, Date creationDate, Date lastUpdateDate, User sender, User reciever) {
		super();
		this.id = id;
		Description = description;
		this.creationDate = creationDate;
		this.lastUpdateDate = lastUpdateDate;
		Sender = sender;
		Reciever = reciever;
	}

	public Message(String description, User sender, User reciever) {
		super();
		Description = description;
		Sender = sender;
		Reciever = reciever;
	}

}
