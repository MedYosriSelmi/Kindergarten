package tn.kindergarten.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ListParticipantsPK   implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private int idUser;
	
	private int idEvent;

	public ListParticipantsPK() {
		super();
	}

	public ListParticipantsPK(int idUser, int idEvent) {
		super();
		this.idUser = idUser;
		this.idEvent = idEvent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEvent;
		result = prime * result + idUser;
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
		ListParticipantsPK other = (ListParticipantsPK) obj;
		if (idEvent != other.idEvent)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	@Override
	public String toString() {
		return "ListParticipantsPK [idUser=" + idUser + ", idEvent=" + idEvent + "]";
	}
	
	

	
}
