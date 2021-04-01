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

@Entity
public class CommentPub implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String Description;
	
	@Column(updatable = false, nullable = false)
	private Date DateDelivered;
	
	@ManyToOne 
	private Publication pub;
	
	@ManyToOne
	private User user;
	
	@PrePersist
	protected void onCreate() {
		this.DateDelivered = new Date();
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

	public Date getDateDelivered() {
		return DateDelivered;
	}

	public void setDateDelivered(Date dateDelivered) {
		DateDelivered = dateDelivered;
	}

	public Publication getPub() {
		return pub;
	}

	public void setPub(Publication pub) {
		this.pub = pub;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

	

}
