package tn.kindergarten.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;

import com.sun.istack.NotNull;

@Entity
public class Planning implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	

	@Temporal(TemporalType.TIMESTAMP)
	private Date time;
	
	private String Departure;

	private String Destination;
	
	@ManyToOne
	private User user;

	@ManyToOne
	private Kindergarten kidergarten;
	
	public Planning () {
		
	}

	public String getDeparture() {
		return Departure;
	}

	public void setDeparture(String departure) {
		Departure = departure;
	}

	public String getDestination() {
		return Destination;
	}

	public void setDestination(String destination) {
		Destination = destination;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Kindergarten getKidergarten() {
		return kidergarten;
	}

	public void setKidergarten(Kindergarten kidergarten) {
		this.kidergarten = kidergarten;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	
	
	
	

	
}
