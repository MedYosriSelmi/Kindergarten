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
	

	

}
