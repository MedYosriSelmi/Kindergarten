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

	
	
	

	
}
