package tn.kindergarten.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	private boolean isActif;
	
	@Temporal(TemporalType.DATE)
	private Date DateOfBirth;
	
	private String picture;
	
	public User () 
	{
		
	}

	public User(int id, String firstName, String lastName, String email, boolean isActif, Date dateOfBirth,
			String picture) {
		super();
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		this.isActif = isActif;
		DateOfBirth = dateOfBirth;
		this.picture = picture;
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DateOfBirth == null) ? 0 : DateOfBirth.hashCode());
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((FirstName == null) ? 0 : FirstName.hashCode());
		result = prime * result + ((LastName == null) ? 0 : LastName.hashCode());
		result = prime * result + id;
		result = prime * result + (isActif ? 1231 : 1237);
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (DateOfBirth == null) {
			if (other.DateOfBirth != null)
				return false;
		} else if (!DateOfBirth.equals(other.DateOfBirth))
			return false;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (FirstName == null) {
			if (other.FirstName != null)
				return false;
		} else if (!FirstName.equals(other.FirstName))
			return false;
		if (LastName == null) {
			if (other.LastName != null)
				return false;
		} else if (!LastName.equals(other.LastName))
			return false;
		if (id != other.id)
			return false;
		if (isActif != other.isActif)
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email
				+ ", isActif=" + isActif + ", DateOfBirth=" + DateOfBirth + ", picture=" + picture + "]";
	}
	
	
	
	
}
